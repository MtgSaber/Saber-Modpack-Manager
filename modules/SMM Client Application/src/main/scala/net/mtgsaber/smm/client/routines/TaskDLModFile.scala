package net.mtgsaber.smm.client.routines

import net.mtgsaber.smm.client.models.*

import scala.concurrent.{CanAwait, ExecutionContext, Future}
import scala.concurrent.duration.Duration
import scala.util.Try

/**
 * Downloads the provided <code>ModFile</code> to its designated filepath under
 * the root directory of the provided <code>ModPack</code>.
 * TODO: implement
 */
case class TaskDLModFile(pack: Modpack, modFile: ModFile) extends Future[Exception]{
  override def onComplete[U](f: Try[Exception] => U)(implicit executor: ExecutionContext): Unit = {}

  override def isCompleted: Boolean = false

  override def value: Option[Try[Exception]] = None

  override def transform[S](f: Try[Exception] => Try[S])(implicit executor: ExecutionContext): Future[S] = null

  override def transformWith[S](f: Try[Exception] => Future[S])(implicit executor: ExecutionContext): Future[S] = null

  override def ready(atMost: Duration)(implicit permit: CanAwait): TaskDLModFile.this.type = null

  override def result(atMost: Duration)(implicit permit: CanAwait): Exception = null
}

