package net.mtgsaber.smm.client.util

import net.mtgsaber.smm.client.state.Tracking.ProgressHook
import net.mtgsaber.smm.client.util.Http.BodyHandlers.ByteStreamProgressTracking.ByteStreamBodyConsumer
import net.mtgsaber.smm.client.util.JavaOptionals._

import java.io.OutputStream
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandler
import java.nio.file.Path
import java.util.Optional
import java.util.function.Consumer

object Http {
  object BodyHandlers {
    object ByteStreamProgressTracking {
      class ByteStreamBodyConsumer(
        val contentLength: Long,
        val outputStream: OutputStream,
        val progressTracker: Option[Double] => Unit
      ) extends Consumer[Option[Array[Byte]]] {
        private[this] var accepted: Long = 0

        override def accept(data: Option[Array[Byte]]): Unit = {
          if data.isDefined then
            outputStream write data.get
            accepted = accepted + data.get.length
            progressTracker apply accepted
          end if
        }
      }
    }
    case class ByteStreamProgressTracking(
      outputStream: OutputStream, progressTracker: Option[Double] => Unit
    ) extends BodyHandler[Path] {
      override def apply(
        responseInfo: HttpResponse.ResponseInfo
      ): HttpResponse.BodySubscriber[Void] = {
        val contentLength = responseInfo.headers firstValue "content-length" toOption() getOrElse "-1" toLong()
        progressHook start Some(contentLength)
        val consumer = new ByteStreamBodyConsumer(contentLength, outputStream, progressTracker)
        HttpResponse.BodyHandlers.ofByteArrayConsumer(
          data => consumer accept data.toOption
        ) apply responseInfo
      }
    }
  }
}
