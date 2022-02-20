package net.mtgsaber.smm.client.state

import scala.concurrent.ExecutionContext

case class ApplicationState(
  applicationConfig: ApplicationConfig
)

object ApplicationState {
  @volatile var get: ApplicationState = ApplicationState(ApplicationConfig())
}
