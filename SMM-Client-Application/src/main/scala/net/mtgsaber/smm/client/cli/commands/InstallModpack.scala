package net.mtgsaber.smm.client.cli.commands

import net.mtgsaber.smm.client.io.RemoteAPI
import net.mtgsaber.smm.client.state.Tracking.ProgressHook
import net.mtgsaber.smm.client.models.{Modpack, ModpackInstallation, ModpackVersion, PackFile}
import net.mtgsaber.smm.client.routines.ModpackInstallationRoutine
import net.mtgsaber.smm.client.state.ApplicationState
import org.tinylog.Logger
import picocli.CommandLine
import picocli.CommandLine.{Parameters, ParentCommand, Command as CLICommand, Option as CLIOption}

import java.io.File
import java.nio.file.Path
import java.net.URI
import java.util.concurrent.{Callable, TimeUnit}
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.Try

// TODO: when optimizing this for concurrency, remove global context and define a proper execution context
import concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object InstallModpack {
  @CLICommand(
    name = "install",
    description = Array("Installs the specified modpack."),
    mixinStandardHelpOptions = true
  )
  class Command extends Callable[Int] {
    @ParentCommand
    private var parent: CLIMain = null

    @Parameters(
      index = "0",
      description = Array("The ID of the modpack to install. For a table of modpack IDs, visit the SMM website or check the discord!"),
    )
    private var modpackID: String = null

    @CLIOption(
      names = Array("--pack-version", "--version"),
      description = Array("A specific version of the desired modpack. Usually best to just use the latest."),
      defaultValue = "latest",
      hidden = true
    )
    private var modpackVersionID: String = null

    @CLIOption(
      names = Array("--memory-mb", "--memory", "--ram", "--ram-mb", "--alloc", "--allocate"),
      description = Array("The amount of memory (RAM) to allocate to instances of this modpack installation."),
      defaultValue = "2048"
    )
    private var memoryAllocationMB: Short = 2048

    @CLIOption(
      names = Array("--path"),
      description = Array("The directory (folder) to use as the installation root for this modpack. Root directories are usually empty before installation."),
      defaultValue = "./"
    )
    private var installationPath: Path = null

    /**
     * Performs the modpack installation process and returns its exit code.
     */
    override def call(): Int = {
      // TODO: implement
      val routine: Future[Int] = Future[ModpackVersion] {
        if modpackVersionID == "latest" then
          RemoteAPI.getPackLatestVersion(
            Modpack(modpackID), ProgressHooks.APIHooks.getPackLatestVersion, ApplicationState.get
          )
        else
          RemoteAPI.getPackVersions(
            Modpack(modpackID), ProgressHooks.APIHooks.getPackVersions, ApplicationState.get
          ).filter({
            // TODO: implement this. also check usage of futures and see if Try[] wrapping is needed or redundant.
            _.versionID == modpackVersionID
          }).head
      } map {
        version => {
          val minecraftInstallationSpec = ApplicationState.get.applicationConfig.mcInstallationSpec
          val modpackInstallation = ModpackInstallation(installationPath, version)
          ModpackInstallationRoutine(
            minecraftInstallationSpec, modpackInstallation, ProgressHooks.routineHooks
          ).start()
        }
      } map {
        _ => 0
      } recover {
        _ => {
          Logger.info(() => "Exception caught!")
          -1
        } // TODO: map exceptions to exit codes
      }

      Await.result(routine, Duration(30, TimeUnit.SECONDS))
    }
  }

  object ProgressHooks {
    val routineHooks: ModpackInstallationRoutine.ProgressHookDefinition = ModpackInstallationRoutine.ProgressHookDefinition(
      start = ProgressHook[String, String, String](
        start = _ => {
          Logger.info(() => "Beginning installation routine...")
        },
        progress = (_, _) => {

        },
        stop = _ => {
          Logger.info(() => "Installation routine complete.")
        }
      ),

      downloadFiles = ProgressHook[Set[PackFile], PackFile, Set[PackFile]](
        start = _ => {
          Logger.info(() => "Installation routine: Beginning files download process....")
        },
        progress = (_, _) => {

        },
        stop = _ => {
          Logger.info(() => "Installation routine: File downloads complete.")
        }
      ),

      downloadFile = ProgressHook[PackFile, PackFile, PackFile](
        start = (packFile: Option[PackFile]) => {
          Logger.info(
            () => "Installation routine: Begin download \"" + (
              packFile match {
                case Some(packFile) => packFile.toString
                case None => ""
              }
            ) + "\"..."
          )
        },
        progress = (_, _) => {

        },
        stop = (result: Try[Option[PackFile]]) => {
          result match {
            case Success(value) => {
              Logger.info(
                () => "Installation routine: End download \"" + (
                  value match {
                    case Some(packFile) => packFile.toString
                    case None => ""
                  }
                  ) + "\""
              )
            }
          }
        }
      ),

      injectMCProfile = ProgressHook[String, String, String](
        start = _ => {
          Logger.info(() => "Installation routine: Beginning profile injection...")
        },
        progress = (_, _) => {

        },
        stop = _ => {
          Logger.info(() => "Installation routine: Profile injection complete.")
        }
      )
    )

    object APIHooks {
      val getPackLatestVersion: ProgressHook[URI, URI, URI] = ProgressHook(
        start = _ => {

        },
        progress = (_, _) => {

        },
        stop = _ => {

        }
      )

      val getPackList: ProgressHook[URI, URI, URI] = ProgressHook(
        start = _ => {

        },
        progress = (_, _) => {

        },
        stop = _ => {

        }
      )

      val getPackVersions: ProgressHook[URI, URI, URI] = ProgressHook(
        start = _ => {

        },
        progress = (_, _) => {

        },
        stop = _ => {

        }
      )

      val getPackBaseProfile: ProgressHook[URI, URI, URI] = ProgressHook(
        start = _ => {

        },
        progress = (_, _) => {

        },
        stop = _ => {

        }
      )
    }
  }
}
