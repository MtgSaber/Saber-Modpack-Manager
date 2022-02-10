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

  def getPackList(
    hookDictionary: HookDictionary, applicationState: ApplicationState
  ): Future[List[Modpack]] = {
    Future {
      throw new NotImplementedError()
    } (applicationState.executionContexts.get(ApplicationExecutionContextCategories.SMMAPICalls))
  }

  def getPackVersions(
    modpack: Modpack, hookDictionary: HookDictionary, applicationState: ApplicationState
  ): Future[List[ModpackVersion]] = {
    Future {
      throw new NotImplementedError()
    } (applicationState.executionContexts.get(ApplicationExecutionContextCategories.SMMAPICalls))
  }

  def getPackLatestVersion(
    modpack: Modpack, hookDictionary: HookDictionary, applicationState: ApplicationState
  ): Future[ModpackVersion] = {
    Future {
      throw new NotImplementedError()
    } (applicationState.executionContexts.get(ApplicationExecutionContextCategories.SMMAPICalls))
  }

  def getPackBaseProfile(
    modpack: Modpack, hooks: HookDictionary, applicationState: ApplicationState
  ): Future[MCProfile] = {
    Future {
      throw new NotImplementedError()
    } (applicationState.executionContexts.get(ApplicationExecutionContextCategories.SMMAPICalls))
  }
}
