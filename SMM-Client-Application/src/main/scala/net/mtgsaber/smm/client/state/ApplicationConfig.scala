package net.mtgsaber.smm.client.state

import net.mtgsaber.smm.client.models.MCInstallationSpec

/**
 * Mutable container for all app-wide configurations. This is usually loaded from the application's config.yaml.
 */
case class ApplicationConfig(
  mcInstallationSpec: MCInstallationSpec
)

object ApplicationConfig {
  def apply(): ApplicationConfig = {
    // TODO: implement. load from yaml config file into helper POJO, then convert that into an instance of this class.
    null
  }
}
