package net.mtgsaber.smm.client

import scala.util.Try

object ProgressTracking {
  /**
   * Callbacks for handling the start of a task, an update to that task's progress, and the ending of that task.
   */
  case class ProgressHook(
    start: Option[AnyVal] => Unit,
    progress: (Option[AnyVal], Option[Double]) => Unit,
    stop: Try[Option[AnyVal]] => Unit
  )

  /**
   * Used to hold tagged [[ProgressHook]]s. Used as input for many [[routines]]. Tag enumerations
   * can be found as a member of their corresponding [[routines]].
   */
  type HookDictionary = Map[AnyRef, ProgressHook]
}
