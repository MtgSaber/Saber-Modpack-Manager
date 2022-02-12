package net.mtgsaber.smm.client.io

import net.mtgsaber.smm.client.models.{MCInstallationSpec, MCProfile}
import net.mtgsaber.smm.client.state.Tracking.ProgressHook

import scala.concurrent.Future
import scala.util.Try

/**
 * Contains utilities for manipulating local data such as the profiles file, mod files, etc.
 */
object LocalOutputs {
  /**
   * Writes the provided list of profiles to the users's Minecraft Profiles file.<br/>
   * Implementation Instructions:
   * - Be careful, since this may cause many problems for the user, such as loss of data, if done incorrectly.
   *
   * @param mcInstallation Metadata of the user's Minecraft installation. Needed for profiles manipulation.
   * @param profiles       The list of profiles to write to the user's profiles file.
   * @param hook           A progress hook for this process.
   * @return A Failure with any raised Exception or Success.
   */
  private def writeMCProfiles(
    mcInstallation: MCInstallationSpec,
    profiles: List[MCProfile],
    hook: ProgressHook[String, String, String]
  ): Future[Try[Unit]] = {
    null
  }
}
