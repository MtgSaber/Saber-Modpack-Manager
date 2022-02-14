package net.mtgsaber.smm.client.io

import net.mtgsaber.smm.client.state.*

import java.net
import java.net.http.HttpResponse.BodyHandler
import java.net.{StandardProtocolFamily, URI, URL}
import java.net.http.{HttpClient, HttpRequest, HttpResponse}
import java.time.Duration

object RemoteGET {
  def simpleGET[ResponseType](uri: URI, bodyHandler: BodyHandler): HttpResponse[ResponseType] = {
    // TODO: ssl context???
    HttpClient
      .newBuilder()
      .version(HttpClient.Version.HTTP_2)
      .connectTimeout(Duration.ofSeconds(ApplicationState.get.applicationConfig.remoteGETTimeoutSeconds))
      .followRedirects(HttpClient.Redirect.NORMAL)
      .send(
        HttpRequest
          .newBuilder(uri)
          .version(httpClientBuilder.version())
          .timeout(httpClientBuilder.connectTimeout())
          .GET()
          .build(),
        bodyHandler
    )
  }

  def simpleGET[ResponseType](uri: String, bodyHandler: BodyHandler): HttpResponse[ResponseType] = {
    simpleGET(URI.create(uri), bodyHandler)
  }

  def simpleGET[ResponseType](
    host: String, port: Int = 80, path: String, useSSL: Boolean = true, bodyHandler: BodyHandler
  ): HttpResponse[ResponseType] = {
    simpleGET(
      "http"
        + (if useSSL then "s" else "")
        + "://" + host + ":" + port
        + (if path.charAt(0) != "/" then "/" else "")
        + path,
      bodyHandler
    )
  }
}
