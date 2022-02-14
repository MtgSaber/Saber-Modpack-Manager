package net.mtgsaber.smm.client.models

/**
 * Represents someone on the internet who has authored some mod, library, or modpack.
 */
case class Author(id: String, name: String, handle: String, websiteURI: String, profileURIs: Set[String]) {
  
}
