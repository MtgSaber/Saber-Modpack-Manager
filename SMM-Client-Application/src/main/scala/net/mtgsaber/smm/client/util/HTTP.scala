package net.mtgsaber.smm.client.util

import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandler
import java.nio.file.Path
import java.util.Optional

object HTTP {
  object BodyHandlers {
    class ByteStreamProgressTracking() extends BodyHandler[Path] {
      def accept(optByteArr: Optional[Array[Byte]]): Void = {
      }

      override def apply(
        responseInfo: HttpResponse.ResponseInfo
      ): HttpResponse.BodySubscriber[Void] = {
        HttpResponse.BodyHandlers.ofByteArrayConsumer(t => this accept t).apply(responseInfo)
      }
    }
  }
}
