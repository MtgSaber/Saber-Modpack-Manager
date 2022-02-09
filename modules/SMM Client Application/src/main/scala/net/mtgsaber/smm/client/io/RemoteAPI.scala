package net.mtgsaber.smm.client.io

import net.mtgsaber.smm.client.state.Tracking.HookDictionary
import net.mtgsaber.smm.client.models.{MCProfile, Modpack, ModpackVersion}
import net.mtgsaber.smm.client.state.ApplicationState
import net.mtgsaber.smm.client.state.ApplicationExecutionContextCategories

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Try}

/**
 * Contains utilities for I/O with the SMM API.
 */
object RemoteAPI 
{
  enum HookPoints {
    case getPackList
    case getPackVersions
    case getPackBaseProfile
  }

  def getPackList(hookDictionary: HookDictionary, applicationState: ApplicationState): Future[Try[List[Modpack]]] = {
    implicit val ec: ExecutionContext = applicationState.executionContexts.get(ApplicationExecutionContextCategories.SMMAPICalls)
    Future {
      Failure(new NotImplementedError())
    }
  }

  def getPackVersions(modpack: Modpack, hookDictionary: HookDictionary, applicationState: ApplicationState): Future[Try[List[ModpackVersion]]] = {
    implicit val ec: ExecutionContext = applicationState.executionContexts.get(ApplicationExecutionContextCategories.SMMAPICalls)
    Future {
      Failure(new NotImplementedError())
    }
  }

  def getPackLatestVersion(modpack: Modpack, hookDictionary: HookDictionary, applicationState: ApplicationState): Future[Try[ModpackVersion]] = {
    implicit val ec: ExecutionContext = applicationState.executionContexts.get(ApplicationExecutionContextCategories.SMMAPICalls)
    Future {
      Failure(new NotImplementedError())
    }
  }

  def getPackBaseProfile(modpack: Modpack, hooks: HookDictionary, applicationState: ApplicationState): Future[Try[MCProfile]] = {
    implicit val ec: ExecutionContext = applicationState.executionContexts.get(ApplicationExecutionContextCategories.SMMAPICalls)
    Future {
      Failure(new NotImplementedError())
    }
  }
}
