package net.mtgsaber.smm.client.state

import net.mtgsaber.smm.client.routines

import scala.util.Try

object Tracking {
  /**
   * Callbacks for handling the start of a task, an update to that task's progress, and the ending of that task.
   */
  case class ProgressHook[Start, Progress, Stop](
    start: Option[Start] => Unit,
    progress: (Option[Progress], Option[Double]) => Unit,
    stop: Try[Option[Stop]] => Unit
  )
}
