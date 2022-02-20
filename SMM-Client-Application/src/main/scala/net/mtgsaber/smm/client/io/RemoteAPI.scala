package net.mtgsaber.smm.client.io

import net.mtgsaber.smm.client.state.Tracking.ProgressHook
import net.mtgsaber.smm.client.models.{Author, MCProfile, Mod, Modpack, ModpackVersion, PackFile}
import net.mtgsaber.smm.client.state.ApplicationState

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
    Set(Modpack(
      "an id", "Test Modpack",
      Author("123", "an author", "a handle", "a URI", Set()),
      "a URI", Set()
    ))
  }

  def getPackVersions(
    modpackID: String,
    hook: ProgressHook[URI, URI, URI],
    applicationState: ApplicationState
  ): Set[ModpackVersion] = {
    hook start None
    hook stop Success(None)
    Set(ModpackVersion(
      Modpack(
        modpackID, "Test Modpack",
        Author("123", "an author", "a handle", "a URI", Set()),
        "a URI", Set()
      ),
      "v0.0.1", "test-forge-version",
      Map(
        PackFile(
          "https://www.curseforge.com/minecraft/mc-mods/jei/download/3599262", "./tmp/mods/jei"
        ) -> Mod(
          "an id", "jei",
          Author("an id", "a name", "a handle", "a uri", Set()),
          "a project uri", "a description uri"
        )
      ),
      Map(), List(), 4096
    ))
  }

  def getPackLatestVersion(
    modpackID: String,
    hook: ProgressHook[URI, URI, URI],
    applicationState: ApplicationState
  ): ModpackVersion = {
    hook start None
    hook stop Success(None)
    ModpackVersion(
      Modpack(
        modpackID, "Test Modpack",
        Author("123", "an author", "a handle", "a URI", Set()),
        "a URI", Set()
      ),
      "v0.0.1", "test-forge-version",
      Map(
        PackFile(
          "https://www.curseforge.com/minecraft/mc-mods/jei/download/3599262", "./tmp/mods/jei"
        ) -> Mod(
          "an id", "jei",
          Author("an id", "a name", "a handle", "a uri", Set()),
          "a project uri", "a description uri"
        )
      ),
      Map(), List(), 4096
    )
  }

  def getPackBaseProfile(
    modpackID: String,
    hook: ProgressHook[URI, URI, URI],
    applicationState: ApplicationState
  ): MCProfile = {
    hook start None
    hook stop Success(None)
    MCProfile()
  }
}
