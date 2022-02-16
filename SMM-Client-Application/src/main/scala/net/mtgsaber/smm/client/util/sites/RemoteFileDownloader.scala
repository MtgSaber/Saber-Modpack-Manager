package net.mtgsaber.smm.client.util.sites

import java.net.URI

trait RemoteFileDownloader {
  def download(remoteURI: URI, localURI: URI, headers: HttpResponse)
}
