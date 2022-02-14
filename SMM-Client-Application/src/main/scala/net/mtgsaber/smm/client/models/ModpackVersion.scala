package net.mtgsaber.smm.client.models

/**
 * Represents a particular version of a Minecraft modpack, including the specific mods and files.
 */
case class ModpackVersion(
  modpack: Modpack, versionID: String, forgeVersion: String,
  modFiles: Map[PackFile, Mod], configFiles: Map[PackFile, Mod],
  otherFiles: List[PackFile], recommendedMemAllocMB: Int
)
