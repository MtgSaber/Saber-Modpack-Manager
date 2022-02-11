package net.mtgsaber.smm.client.io

import net.mtgsaber.smm.client.models.{MCInstallationSpec, MCProfile, ModpackInstallation}

/**
 * Contains utilities for reading and validating local files and configurations.
 */
object LocalInputs {
  /**
   * Utility function for <code>injectMCProfile()</code>. Reads the file as JSON and parses the entries into a list.
   *
   * @param mcInstallation Metadata of the user's Minecraft installation. Needed for profiles manipulation.
   * @return A list of the current profiles in the user's Minecraft installation.
   */
  private def readMCProfiles(mcInstallation: MCInstallationSpec): List[MCProfile] = {
    null // TODO: implement
  }

  /**
   * Utility function which searches the provided list of profiles for one which corresponds to this installation spec.
   *
   * @param optProfiles      The profile list to search. If no list is given, will read from file.
   * @param packInstallation The metadata about this installation, including root directory and profile variables.
   * @param mcInstallation   Metadata of the user's Minecraft installation. Needed for profiles manipulation.
   * @return The profile if found.
   */
  private def getExistingProfile(
    optProfiles: Option[List[MCProfile]] = Option.empty,
    packInstallation: ModpackInstallation,
    mcInstallation: MCInstallationSpec
  ): Option[MCProfile] = {
    val profiles: List[MCProfile] = optProfiles getOrElse readMCProfiles(mcInstallation)

    null // TODO: implement
  }
}
