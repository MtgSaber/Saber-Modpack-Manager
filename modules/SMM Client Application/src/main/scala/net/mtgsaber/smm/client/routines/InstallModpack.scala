package net.mtgsaber.smm.client.routines

import net.mtgsaber.smm.client.models.{ModpackInstallation, ModpackVersion, PackFile}

import java.io.File
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse.BodyHandlers
import java.net.{ProxySelector, URI}
import java.net.http.{HttpClient, HttpRequest}
import java.nio.file.{Files, Path}
import java.time.Duration
import scala.concurrent.*
import ExecutionContext.Implicits.global
import scala.util.Try

object InstallModpack {
  /**
   * Callbacks for handling the start of a task, an update to that task's progress, and the ending of that task.
   */
  type ProgressHook = (String => Unit, Float => Unit, Try[Unit] => Unit)
  /**
   * Used to hold all callbacks for tracking the progress of modpack installation.
   * Fields will all be tuples of functions.
   */
  type ProgressTrackingSpec = Map[String, ProgressHook]

  /**
   * Downloads the modpack contents and injects a profile.
   * @param pack The modpack version to install.
   * @param root The installation directory for this pack.
   * @tparam U
   * @return
   */
  def apply(installation: ModpackInstallation, progressTrackingSpec: ProgressTrackingSpec): Future[Unit] = {
    null
  }

  /**
   * Downloads all files for the pack.
   * @param modpackInstallation
   * @return
   */
  private def downloadFiles(
                             modpackInstallation: ModpackInstallation,
                             progressTrackingSpec: ProgressTrackingSpec
  ): Future[Unit] = {
    null
  }

  private def downloadFile(packFile: PackFile, progressHook: ProgressHook): Future[Unit] = {
    null
  }
}
