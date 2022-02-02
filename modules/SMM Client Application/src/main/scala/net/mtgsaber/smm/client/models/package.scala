package net.mtgsaber.smm.client

/**
 * All of the data models of the Client Application.
 */
package object models {
  case class Author(name: String, webpage: String)
  case class ConfigFile()
  case class Mod()
  case class ModeFile()
  case class MCProfile()
  case class Modpack()
  case class ModpackVersion()
  case class PackFile()
}
