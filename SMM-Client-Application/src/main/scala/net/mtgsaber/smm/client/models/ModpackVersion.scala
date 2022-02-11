package net.mtgsaber.smm.client.models

/**
 * Represents a particular version of a Minecraft modpack, including the specific mods and files.
 */
case class ModpackVersion(
  modpack: Modpack, versionID: String, forgeVersion: String,
  modFiles: Map[Mod, PackFile], configFiles: Map[Mod, PackFile],
  otherFiles: List[PackFile], recommendedMemAllocMB: Int
)
