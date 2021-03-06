package net.mtgsaber.smm.client.routines

import net.mtgsaber.smm.client.models.{MCInstallationSpec, MCProfile, Mod, ModpackInstallation, PackFile}
import net.mtgsaber.smm.client.routines.ModpackInstallationRoutine.ProgressHookDefinition
import net.mtgsaber.smm.client.state.ApplicationState
import net.mtgsaber.smm.client.state.Tracking.ProgressHook
import net.mtgsaber.smm.client.util.http.BodyHandlers
import net.mtgsaber.smm.client.util.FileHosts
import net.mtgsaber.smm.client.util.http

import java.io.FileOutputStream
import java.net.URI
import java.net.http.HttpResponse.BodyHandlers
import java.net.http.{HttpClient, HttpRequest}
import java.nio.file.{Files, Path, Paths, StandardOpenOption}
import java.time.Duration
import scala.None
import scala.concurrent.*
import scala.util.{Success, Try, Using}

object ModpackInstallationRoutine {
  /**
   * Observers of the progress of the processes encapsulated by this routine.
   */
  case class ProgressHookDefinition(
    start: ProgressHook[String, String, String],
    downloadMods: ProgressHook[Int, (PackFile, Mod), Int],
    downloadConfigs: ProgressHook[Int, (PackFile, Mod, Int), Int],
    downloadOthers: ProgressHook[Int, PackFile, Int],
    downloadFile: ProgressHook[PackFile, (PackFile, Long, Long), PackFile],
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
  /*
   * TODO: add mutable fields as necessary to facilitate synchronization and inter-process communication.
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
  private[this] def downloadMods(): Unit = {
    hooks.downloadMods start Some(packInstallation.modpackVersion.modFiles.size)

    packInstallation.modpackVersion.modFiles foreach((file, mod) => {
      hooks.downloadMods progress Some(file, mod)
      this downloadFile file
    })

    hooks.downloadMods stop Success(Some(packInstallation.modpackVersion.modFiles.size))
  }

  /**
   * Downloads all config files for the pack.
   */
  private[this] def downloadConfigs(): Unit = {
    hooks.downloadConfigs start Some(packInstallation.modpackVersion.configFiles.size)

    // TODO: group map of config files to count number of configs for each mod.
    // TODO: use result of grouping in closure below.

    packInstallation.modpackVersion.configFiles foreach((file, mod) => {
      hooks.downloadConfigs progress Some(file, mod, 1)
      this downloadFile file
    })

    hooks.downloadConfigs stop Success(Some(packInstallation.modpackVersion.configFiles.size))
  }

  /**
   * Downloads all miscellaneous files for the pack.
   */
  private[this] def downloadOthers(): Unit = {

  }

  /**
   * Downloads an individual file.<br/>
   * Implementation Instructions:
   *  - Make sure to abide by CurseForge's robots policy. Generally, for each download site, only download one
   *    mod at a time from it.
   * @param packFile The individual file to download.
   */
  private[this] def downloadFile(packFile: PackFile): Unit = {
    hooks.downloadFile start Some(packFile)

    val remoteURI = URI create packFile.sourceURI
    // TODO: determine why FileOutputStream is invalid for the Using syntax.
    val fout = new FileOutputStream((packInstallation.root resolve packFile.localPath).toFile)

    try {
      remoteURI.getHost.toLowerCase match {
        case FileHosts.CurseForge.hostname => {
          HttpClient.newBuilder
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(30)) // TODO: reference the app config for timeouts
            .build
            .send(
              HttpRequest.newBuilder(remoteURI)
                .version(HttpClient.Version.HTTP_1_1)
                .timeout(Duration.ofMinutes(15)) // TODO: reference the app config for timeouts
                .GET
                .build,
              new http.BodyHandlers.ByteStreamProgressTracking(fout, fileDownloadHookAdapter apply packFile)
            )
        }
        case FileHosts.Micdoodle8.hostname => {
          // TODO: handle micdoodle8 mod downloads
        }
        case _ => {
          // TODO: handle other mod downloads
        }
      }
    } finally {
        fout.close()
    }

    hooks.downloadFile stop Success(Some(packFile))
  }
  
  private[this] val fileDownloadHookAdapter: PackFile => (Long, Long) => Unit =
    packFile => (progressBytes, contentLength) => {
      hooks.downloadFile progress Some((packFile, progressBytes, contentLength))
  }

  /**
   * Adds the profile for this pack into the user's Minecraft Profiles file.
   */
  private[this] def injectMCProfile(): Unit = {
    hooks.injectMCProfile start None

    hooks.injectMCProfile stop Success(None)
  }
}
