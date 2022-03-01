package net.mtgsaber.smm.client.cli.test

import net.mtgsaber.smm.client.util.{FileHosts, http}

import java.io.{File, FileOutputStream}
import java.net.URI
import java.net.http.{HttpClient, HttpRequest}
import java.time.Duration

object DLTesting {
  def main(args: Array[String]): Unit = {
    assert(args.length == 2)
    val remoteURI = URI create args(0)
    // TODO: determine why FileOutputStream is invalid for the Using syntax.
    val fout = new FileOutputStream(new File(args(1)))

    val headers = Map(

    )

    remoteURI.getHost.toLowerCase
    try {
      remoteURI.getHost.toLowerCase match {
        case FileHosts.CurseForge.hostname => {
          HttpClient.newBuilder
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(30)) // TODO: reference the app config for timeouts
            .build
            .send(
              HttpRequest.newBuilder(remoteURI)
                .version(HttpClient.Version.HTTP_1_1)
                .timeout(Duration.ofMinutes(15)) // TODO: reference the app config for timeouts
                .GET
                .build,
              new http.BodyHandlers.ByteStreamProgressTracking(fout, (a, b) => println(s"$a / $b"))
            ).statusCode()
        }
        case FileHosts.Micdoodle8.hostname => {
          // TODO: handle micdoodle8 mod downloads
        }
        case _ => {
          // TODO: handle other mod downloads
        }
      }
    } catch {
      case e: Throwable => e.printStackTrace()
    } finally {
      fout.close()
    }
    fout.close()
  }
}
