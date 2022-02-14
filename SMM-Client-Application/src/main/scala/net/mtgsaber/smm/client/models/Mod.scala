package net.mtgsaber.smm.client.models

import java.net.URI

/**
 * Represents a mod as a project, NOT as a particular version. Usually corresponds to a CurseForge mod page.
 */
case class Mod(id: String, name: String, author: Author, projectURI: String, descriptionURI: String) {
  
}
