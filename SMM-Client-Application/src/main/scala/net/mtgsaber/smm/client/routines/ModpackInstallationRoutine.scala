package net.mtgsaber.smm.client.routines

import io.netty.channel.ChannelOption
import net.mtgsaber.smm.client.cli.commands.CLIMain.applicationState
import net.mtgsaber.smm.client.models.{MCInstallationSpec, MCProfile, Mod, ModpackInstallation, PackFile}
import net.mtgsaber.smm.client.routines.ModpackInstallationRoutine.ProgressHookDefinition
import net.mtgsaber.smm.client.state.{ApplicationExecutionContextCategories, ApplicationState}
import net.mtgsaber.smm.client.state.Tracking.ProgressHook
import net.mtgsaber.smm.client.util.FileHosts
import org.springframework.core.io.buffer.{DataBuffer, DataBufferUtils}
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClient.{RequestBodySpec, RequestHeadersUriSpec}
import reactor.netty.http.client.HttpClient

import java.net.URI
import java.nio.file.{Files, Path, StandardOpenOption}
import java.time.Duration
import scala.None
import scala.concurrent.*
import scala.util.{Success, Try}

object ModpackInstallationRoutine {
  /**
   * Observers of the progress of the processes encapsulated by this routine.
   */
  case class ProgressHookDefinition(
    start: ProgressHook[String, String, String],
    downloadMods: ProgressHook[Int, (PackFile, Mod), Int],
    downloadConfigs: ProgressHook[Int, (PackFile, Mod, Int), Int],
    downloadOthers: ProgressHook[Int, PackFile, Int],
    downloadFile: ProgressHook[PackFile, PackFile, PackFile],
    injectMCProfile: ProgressHook[String, String, String]
  )
}

/**
 * Models the entire installation process. This is the entire application logic of the full feature.
 * @param packInstallation The metadata about this installation, including root directory and profile variables.
 * @param mcInstallation Metadata of the user's Minecraft installation. Needed for profiles manipulation.
 * @param hooks The progress hooks for the installation process.
 */
case class ModpackInstallationRoutine(
  mcInstallation: MCInstallationSpec,
  packInstallation: ModpackInstallation,
  hooks: ProgressHookDefinition,
) {
  /* TODO: add mutable fields as necessary to facilitate synchronization and inter-process communication.
   *       One such communication is the sequential download of files from CurseForge, which forbids
   *       automated concurrent downloads and imposes a delay between automated requests as per
   *       https://www.curseforge.com/robots.txt
   */

  /**
   * Downloads the modpack contents and injects a profile.
   * @return a <code>Future</code> which performs the installation process.
   */
  def start(): Unit = {
    hooks.start start None

    Files.createDirectories(packInstallation.root)
    downloadMods()
    downloadConfigs()
    downloadOthers()
    injectMCProfile()

    hooks.start stop Success(None)
  }

  /**
   * Downloads all mods for the pack.
   */
  private def downloadMods(): Unit = {
    hooks.downloadMods start packInstallation.modpackVersion.modFiles.size

    packInstallation.modpackVersion.modFiles foreach((file, mod) => {
      hooks.downloadMods progress (Some (file, mod), None)
      this downloadFile file
    })

    hooks.downloadMods stop Success(packInstallation.modpackVersion.modFiles.size)
  }

  /**
   * Downloads all config files for the pack.
   */
  private def downloadConfigs(): Unit = {
    hooks.downloadConfigs start packInstallation.modpackVersion.configFiles.size

    // TODO: group map of config files to count number of configs for each mod.
    // TODO: use result of grouping in closure below.

    packInstallation.modpackVersion.configFiles foreach((file, mod) => {
      hooks.downloadConfigs progress (Some((file, mod, 1)), None)
      this downloadFile file
    })

    hooks.downloadConfigs stop Success(packInstallation.modpackVersion.configFiles.size)
  }

  /**
   * Downloads all miscellaneous files for the pack.
   */
  private def downloadOthers(): Unit = {

  }

  /**
   * Downloads an individual file.<br/>
   * Implementation Instructions:
   *  - Make sure to abide by CurseForge's robots policy. Generally, for each download site, only download one
   *    mod at a time from it.
   * @param packFile The individual file to download.
   */
  private def downloadFile(packFile: PackFile): Unit = {
    hooks.downloadFile start Some(packFile)

    // TODO: resolve file path against root path before downloading!
    // TODO: use WebClient to download the file.
    val remoteURI = URI create packFile.sourceURI
    remoteURI.getHost.toLowerCase match {
      case FileHosts.CurseForge.hostname => {
        val y = DataBufferUtils.write(
          WebClient.builder
            .clientConnector(new ReactorClientHttpConnector(
              HttpClient.create
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, ApplicationState.get.applicationConfig.remoteGETTimeoutSeconds)
                .responseTimeout(Duration.ofMillis(ApplicationState.get.applicationConfig.remoteGETTimeoutSeconds))
            ))
            .build
            .get
            .uri(remoteURI)
            .retrieve
            .bodyToFlux(classOf[DataBuffer]),
          Path.of(URI create packFile.localPath),
          StandardOpenOption.CREATE
        )// TODO: continue this function call chain to track the download progress.
        // TODO: should also check if the timeout specified earlier will trigger if the download stalls.

      }
      case FileHosts.Micdoodle8.hostname => {
        // TODO: handle micdoodle8 mod downloads
      }
      case _ => {
        // TODO: handle other mod downloads
      }
    }

    hooks.downloadFile stop Success(Some(packFile))
  }

  /**
   * Adds the profile for this pack into the user's Minecraft Profiles file.
   */
  private def injectMCProfile(): Unit = {
    hooks.injectMCProfile start None

    hooks.injectMCProfile stop Success(None)
  }
}
