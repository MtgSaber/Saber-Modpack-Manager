package net.mtgsaber.smm.client.routines

import net.mtgsaber.smm.client.models.{MCInstallationSpec, MCProfile, ModpackInstallation, PackFile}
import net.mtgsaber.smm.client.routines.ProgressTracking.{HookDictionary, ProgressHook}

import scala.concurrent.*
import ExecutionContext.Implicits.global
import scala.util.Try

/**
 * Models the entire installation process. This is the entire application logic of a full feature.
 */
object InstallModpack {
  /* TODO: add mutable fields as necessary to facilitate synchronization and inter-process communication.
   *       One such communication is the sequential download of files from CurseForge, which forbids
   *       automated concurrent downloads and imposes a delay between automated requests as per
   */

  /**
   * Downloads the modpack contents and injects a profile.
   * @param mcInstallationSpec Metadata of the user's Minecraft installation. Needed for profile injection.
   * @param installation The metadata about this installation, including root directory and profile variables.
   * @param hooks The progress hooks for the installation process.
   * @return a <code>Future</code> which performs the installation process.
   */
  def apply(
             mcInstallationSpec: MCInstallationSpec,
             installation: ModpackInstallation,
             hooks: HookDictionary
  ): Future[Unit] = {
    null
  }

  /**
   * Downloads all files for the pack.
   * @param installation The metadata about this installation, including root directory and profile variables.
   * @param hooks The progress hooks for the installation process.
   * @return A <code>Future</code> which downloads all of the files requested by <code>installation</code>,
   *         some of which may be concurrent within this process.
   */
  private def downloadFiles(
                             installation: ModpackInstallation,
                             hooks: HookDictionary
  ): Future[Unit] = {
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
  private def downloadFile(packFile: PackFile, hook: ProgressHook): Future[Unit] = {
    null
  }

  /**
   * Adds the profile for this pack into the user's Minecraft Profiles file.
   * @param profile The contents of the profile to inject. Must be compatible with the JSON format.
   * @param hooks The progress hooks for the installation process.
   */
  private def injectMCProfile(profile: MCProfile, hooks: HookDictionary): Unit = {

  }

  /**
   * TODO: move this to Diagnostics
   * Utility function for <code>injectMCProfile()</code>. Reads the file as JSON and parses the entries into a list.
   * @return A list of the current profiles in the user's Minecraft installation.
   */
  private def _readMCProfiles(): List[MCProfile] = {
    null
  }

  /**
   * TODO: move this to LocalDataManipulation
   * Writes the provided list of profiles to the users's Minecraft Profiles file.<br/>
   * Implementation Instructions:
   * - Be careful, since this may cause many problems for the user, such as loss of data, if done incorrectly.
   * @param profiles The list of profiles to write to the user's profiles file.
   * @param hook A progress hook for this process.
   * @return A Failure with any raised Exception or Success.
   */
  private def _writeMCProfiles(profiles: List[MCProfile], hook: ProgressHook): Try[Unit] = {
    null
  }

  /**
   * TODO: move this to Diagnostics
   * Utility function which searches the provided list of profiles for one which corresponds to this installation spec.
   * @param profiles The profile list to search.
   * @param installation The metadata about this installation, including root directory and profile variables.
   * @return The profile if found.
   */
  private def _findExistingProfile(profiles: List[MCProfile], installation: ModpackInstallation): Option[MCProfile] = {
    null
  }
}
