package net.mtgsaber.smm.common.models

/**
 * Represents a Minecraft modpack as a project, NOT as any particular version. Primarily metadata.
 */
case class Modpack(id: String, name: String, author: Author, infoURI: String, modList: Set[Mod]) {

}
