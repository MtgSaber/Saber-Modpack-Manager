package net.mtgsaber.smm.client.state

import scala.concurrent.ExecutionContext

case class ApplicationState(
  executionContexts: Map[ApplicationExecutionContextCategories, ExecutionContext],
  applicationConfig: ApplicationConfig
)
