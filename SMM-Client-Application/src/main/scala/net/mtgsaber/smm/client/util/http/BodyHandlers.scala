package net.mtgsaber.smm.client.util.http

import net.mtgsaber.smm.client.util.http.BodyHandlers.ByteStreamProgressTracking.ByteStreamBodyConsumer
import net.mtgsaber.smm.client.util.JavaOptionals._

import java.io.OutputStream
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandler
import java.nio.file.Path
import java.util.function.Consumer

object BodyHandlers {
  object ByteStreamProgressTracking {
    class ByteStreamBodyConsumer(
      val contentLength: Long,
      val outputStream: OutputStream,
      val progressTracker: (Long, Long) => Unit
    ) extends Consumer[Option[Array[Byte]]] {
      private[this] var accepted: Long = 0

      override def accept(data: Option[Array[Byte]]): Unit = {
        if data.isDefined then
          outputStream write data.get
          outputStream.flush()
          accepted = accepted + data.get.length
          progressTracker.apply(accepted, contentLength)
        end if
      }
    }
  }

  case class ByteStreamProgressTracking(
    outputStream: OutputStream, progressTracker: (Long, Long) => Unit
  ) extends BodyHandler[Void] {
    override def apply(
      responseInfo: HttpResponse.ResponseInfo
    ): HttpResponse.BodySubscriber[Void] = {
      val contentLength = ((responseInfo.headers firstValue "content-length").toOption getOrElse "-1").toLong
      val consumer = new ByteStreamBodyConsumer(contentLength, outputStream, progressTracker)
      HttpResponse.BodyHandlers.ofByteArrayConsumer(
        data => consumer accept data.toOption
      ) apply responseInfo
    }
  }
}
