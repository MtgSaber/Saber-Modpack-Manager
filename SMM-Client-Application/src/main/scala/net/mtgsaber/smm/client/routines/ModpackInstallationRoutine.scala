package net.mtgsaber.smm.client.routines

import net.mtgsaber.smm.client.cli.commands.CLIMain.applicationState
import net.mtgsaber.smm.client.models.{MCInstallationSpec, MCProfile, ModpackInstallation, PackFile}
import net.mtgsaber.smm.client.routines.ModpackInstallationRoutine.ProgressHookDefinition
import net.mtgsaber.smm.client.state.ApplicationExecutionContextCategories
import net.mtgsaber.smm.client.state.Tracking.ProgressHook

import scala.None
import scala.concurrent.*
import scala.util.{Success, Try}

object ModpackInstallationRoutine {
  /**
   * Observers of the progress of the processes encapsulated by this routine.
   */
  case class ProgressHookDefinition(
    start: ProgressHook[String, String, String],
    downloadFiles: ProgressHook[Set[PackFile], PackFile, Set[PackFile]],
    downloadFile: ProgressHook[PackFile, PackFile, PackFile],
    injectMCProfile: ProgressHook[String, String, String]
  )
}

/**
 * Models the entire installation process. This is the entire application logic of the full feature.
 * @param packInstallation The metadata about this installation, including root directory and profile variables.
 * @param mcInstallation Metadata of the user's Minecraft installation. Needed for profiles manipulation.
 * @param hooks The progress hooks for the installation process.
 */
case class ModpackInstallationRoutine(
  mcInstallation: MCInstallationSpec,
  packInstallation: ModpackInstallation,
  hooks: ProgressHookDefinition,
) {
  /* TODO: add mutable fields as necessary to facilitate synchronization and inter-process communication.
   *       One such communication is the sequential download of files from CurseForge, which forbids
   *       automated concurrent downloads and imposes a delay between automated requests as per
   *       https://www.curseforge.com/robots.txt
   */

  /**
   * Downloads the modpack contents and injects a profile.
   * @return a <code>Future</code> which performs the installation process.
   */
  def start(): Unit = {
    hooks.start start None

    hooks.start stop Success(None)
  }

  /**
   * Downloads all files for the pack.
   */
  private def downloadFiles(): Unit = {
    hooks.downloadFiles start None

    hooks.downloadFiles stop Success(None)
  }

  /**
   * Downloads an individual file.<br/>
   * Implementation Instructions:
   *  - Make sure to abide by CurseForge's robots policy. Generally, for each download site, only download one
   *    mod at a time from it.
   * @param packFile The individual file to download.
   */
  private def downloadFile(packFile: PackFile): Unit = {
    hooks.downloadFile start Some(packFile)

    hooks.downloadFile stop Success(Some(packFile))
  }

  /**
   * Adds the profile for this pack into the user's Minecraft Profiles file.
   * @param profile The contents of the profile to inject. Must be compatible with the JSON format.
   */
  private def injectMCProfile(profile: MCProfile): Unit = {
    hooks.injectMCProfile start None

    hooks.injectMCProfile stop Success(None)
  }
}
