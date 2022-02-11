package net.mtgsaber.smm.client.cli.commands

import net.mtgsaber.smm.client.io.RemoteAPI
import net.mtgsaber.smm.client.state.Tracking.{HookDictionary, ProgressHook}
import net.mtgsaber.smm.client.io.RemoteAPI.HookPoints as APIHookPoints
import net.mtgsaber.smm.client.models.{Modpack, ModpackInstallation}
import net.mtgsaber.smm.client.routines.ModpackInstallationRoutine
import net.mtgsaber.smm.client.routines.ModpackInstallationRoutine.HookPoints as RoutineHookPoints
import org.tinylog.Logger
import picocli.CommandLine
import picocli.CommandLine.{Command, Option, Parameters, ParentCommand}

import java.io.File
import java.nio.file.Path
import java.net.URI
import java.util.concurrent.{Callable, TimeUnit}
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

@Command(
  name = "install",
  description = Array("Installs the specified modpack."),
  mixinStandardHelpOptions = true
)
class InstallModpack extends Callable[Int] {
  @ParentCommand
  private var parent: Main = null

  @Option(
    names = Array("--pack-id"),
    description = Array("The ID of the modpack to install. For a table of modpack IDs, visit the SMM website or check the discord!"),
    required = true
  )
  private var modpackID: String = null

  @Option(
    names = Array("--pack-version"),
    description = Array("A specific version of the desired modpack. Usually best to just use the latest."),
    defaultValue = "latest",
    hidden = true
  )
  private var modpackVersion: String = null

  @Option(
    names = Array("--memory-mb", "--memory", "--ram", "--ram-mb", "--alloc", "--allocate"),
    description = Array("The amount of memory (RAM) to allocate to instances of this modpack installation."),
    defaultValue = "2048"
  )
  private var memoryAllocationMB: Short = 2048

  @Option(
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
    @volatile var installationResult = 0
    val routine = {
      if modpackVersion == "latest" then
        RemoteAPI.getPackLatestVersion(Modpack(modpackID), hooks, Main.applicationState)
      else
        RemoteAPI.getPackVersions(Modpack(modpackID), hooks, Main.applicationState).filter({
          // TODO: implement this. also check usage of futures and see if Try[] wrapping is needed or redundant.
        })
    }.andThen({
      case Failure(exception) => {
        exception match {
          case _ => {
            // TODO: handle exceptions. should result in an integer return value.
          }
        }
        // TODO: handle failed API call
      }
      case Success(value) => {
        ModpackInstallationRoutine
          .apply(ModpackInstallation(installationPath, version))
          .apply(Main.applicationState.applicationConfig.mcInstallationSpec)
          .apply(hooks)
          .andThen({
            case Failure(exception) => {
              exception match {
                case _ => {
                  // TODO: handle exceptions. should result in an integer return value.
                }
              }
            }
            case Success(value) => installationResult = value
          })
      }
    })
    Await.result(routine, Duration(0, TimeUnit.NANOSECONDS))
    installationResult
  }

  /**
   * Progress tracking hooks for this command. These tuples of functions are used to constantly inform the user
   * of the state of the application.
   */
  private val hooks: HookDictionary = Map(
    RoutineHookPoints.apply -> ProgressHook(
      start = _ => {
        Logger.info("Beginning installation routine...")
      },
      progress = (_, _) => {

      },
      stop = _ => {
        Logger.info("Installation routine complete.")
      }
    ),

    RoutineHookPoints.downloadFiles -> ProgressHook(
      start = _ => {
        Logger.info("Installation routine: Beginning files download process....")
      },
      progress = (_, _) => {

      },
      stop = _ => {
        Logger.info("Installation routine: File downloads complete.")
      }
    ),

    RoutineHookPoints.downloadFile -> ProgressHook(
      start = _ => {
        Logger.info("Installation routine: Begin download \"" + _ + "\"...")
      },
      progress = (_, _) => {

      },
      stop = _ => {
        Logger.info("Installation routine: End download \"" + _ + "\"")
      }
    ),

    RoutineHookPoints.injectMCProfile -> ProgressHook(
      start = _ => {
        Logger.info("Installation routine: Beginning profile injection...")
      },
      progress = (_, _) => {

      },
      stop = _ => {
        Logger.info("Installation routine: Profile injection complete.")
      }
    ),

    APIHookPoints.getPackList -> ProgressHook(
      start = _ => {

      },
      progress = (_, _) => {

      },
      stop = _ => {

      }
    ),

    APIHookPoints.getPackVersions -> ProgressHook(
      start = _ => {

      },
      progress = (_, _) => {

      },
      stop = _ => {

      }
    ),

    APIHookPoints.getPackBaseProfile -> ProgressHook(
      start = _ => {

      },
      progress = (_, _) => {

      },
      stop = _ => {

      }
    ),
  )
}
