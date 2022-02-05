package net.mtgsaber.smm.client.routines

import net.mtgsaber.smm.client.models.{MCInstallationSpec, MCProfile, ModpackInstallation, PackFile}
import net.mtgsaber.smm.client.ProgressTracking.{HookDictionary, ProgressHook}

import scala.concurrent.*
import ExecutionContext.Implicits.global
import scala.util.Try

/**
 * Models the entire installation process. This is the entire application logic of the full feature.
 * TODO: convert all member functions to lazy vals and add tags object.
 */
object ModpackInstallationRoutine {
  /* TODO: add mutable fields as necessary to facilitate synchronization and inter-process communication.
   *       One such communication is the sequential download of files from CurseForge, which forbids
   *       automated concurrent downloads and imposes a delay between automated requests as per
   *       https://www.curseforge.com/robots.txt
   */

  /**
   * Downloads the modpack contents and injects a profile.
   * @param packInstallation The metadata about this installation, including root directory and profile variables.
   * @param mcInstallation Metadata of the user's Minecraft installation. Needed for profiles manipulation.
   * @param hooks The progress hooks for the installation process.
   * @return a <code>Future</code> which performs the installation process.
   */
  def apply(): (ModpackInstallation, MCInstallationSpec, HookDictionary) => Future[Unit] =
    (packInstallation, mcInstallation, hooks) => {
      null
  }

  // TODO: sugar: add builder-pattern overload functions for apply()

  /**
   * Downloads all files for the pack.
   * @param mcInstallation The metadata about this installation, including root directory and profile variables.
   * @param hooks The progress hooks for the installation process.
   * @return A <code>Future</code> which downloads all of the files requested by <code>installation</code>,
   *         some of which may be concurrent within this process.
   */
  private def downloadFiles(): (ModpackInstallation, HookDictionary) => Future[Unit] =
    (mcInstallation, hooks) => {
      null
  }

  /**
   * Downloads an individual file.<br/>
   * Implementation Instructions:
   *  - Make sure to abide by CurseForge's robots policy. Generally, for each download site, only download one
   *    mod at a time from it.
   * @param packFile The individual file to download.
   * @param hook
   * @return A <code>Future</code> which downloads a file. May or may not be concurrent with other file downloads.
   */
  private def downloadFile(): (PackFile, ProgressHook) => Future[Unit] =
    (packFile, hook) => {
     null
  }

  /**
   * Adds the profile for this pack into the user's Minecraft Profiles file.
   * @param profile The contents of the profile to inject. Must be compatible with the JSON format.
   * @param hooks The progress hooks for the installation process.
   */
  private def injectMCProfile(): (MCProfile, HookDictionary) => Unit =
    (profile, hooks) => {
      null
  }
}
