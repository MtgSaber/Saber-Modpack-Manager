package net.mtgsaber.smm.client

import scala.util.Try

object ProgressTracking {
  /**
   * Callbacks for handling the start of a task, an update to that task's progress, and the ending of that task.
   */
  case class ProgressHook(start: String => Unit, progress: (String, Float) => Unit, stop: Try[Unit] => Unit)

  /**
   * Used to hold all callbacks for tracking the progress of modpack installation.
   * Fields will all be tuples of functions.
   */
  type HookDictionary = Map[String, ProgressHook]
}
