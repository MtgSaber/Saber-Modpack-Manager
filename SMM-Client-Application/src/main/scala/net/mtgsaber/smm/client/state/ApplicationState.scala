package net.mtgsaber.smm.client.state

import scala.concurrent.ExecutionContext

case class ApplicationState(
  executionContexts: Map[ApplicationExecutionContextCategories, ExecutionContext],
  applicationConfig: ApplicationConfig
)

object ApplicationState {
  @volatile var get: ApplicationState = ApplicationState(Map(), ApplicationConfig())
}
