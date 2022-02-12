package net.mtgsaber.smm.client.io

import net.mtgsaber.smm.client.state.Tracking.ProgressHook
import net.mtgsaber.smm.client.models.{MCProfile, Mod, Modpack, ModpackVersion, PackFile}
import net.mtgsaber.smm.client.state.ApplicationState
import net.mtgsaber.smm.client.state.ApplicationExecutionContextCategories

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}
import java.net.URI

/**
 * Contains utilities for I/O with the SMM API.
 * TODO: replace dummy code after API deployment.
 */
object RemoteAPI 
{
  def getPackList(
    hook: ProgressHook[URI, URI, URI],
    applicationState: ApplicationState
  ): Set[Modpack] = {
    hook start None
    hook stop Success(None)
    Set(Modpack("test-pack"))
  }

  def getPackVersions(
    modpack: Modpack,
    hook: ProgressHook[URI, URI, URI],
    applicationState: ApplicationState
  ): Set[ModpackVersion] = {
    hook start None
    hook stop Success(None)
    Set(ModpackVersion(Modpack("test-pack"), "v0.0.1", "test-forge-version",
      Map(
        Mod("jei") -> PackFile("https://www.curseforge.com/minecraft/mc-mods/jei/download/3599262", "./tmp/mods/jei")
      ),
      Map(), List(), 4096
    ))
  }

  def getPackLatestVersion(
    modpack: Modpack,
    hook: ProgressHook[URI, URI, URI],
    applicationState: ApplicationState
  ): ModpackVersion = {
    hook start None
    hook stop Success(None)
    ModpackVersion(modpack, "v0.0.1", "test-forge-version",
      Map(
        Mod("jei") -> PackFile("https://www.curseforge.com/minecraft/mc-mods/jei/download/3599262", "./tmp/mods/jei")
      ),
      Map(), List(), 4096
    )
  }

  def getPackBaseProfile(
    modpack: Modpack,
    hook: ProgressHook[URI, URI, URI],
    applicationState: ApplicationState
  ): MCProfile = {
    hook start None
    hook stop Success(None)
    MCProfile()
  }
}
