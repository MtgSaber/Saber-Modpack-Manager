package net.mtgsaber.smm.client.models

import java.net.URI

/**
 * Represents a Minecraft modpack as a project, NOT as any particular version. Primarily metadata.
 */
case class Modpack(id: String, name: String, author: Author, infoURI: String, modList: Set[Mod]) {

}
