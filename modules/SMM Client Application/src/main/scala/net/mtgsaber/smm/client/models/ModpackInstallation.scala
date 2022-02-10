package net.mtgsaber.smm.client.models

import java.nio.file.Path

/**
 * A local installation of a specific version of a modpack. Contains other input data for the
 * [[net.mtgsaber.smm.client.routines.ModpackInstallationRoutine]] routine.
 */
case class ModpackInstallation(root: Path, modpackVersion: ModpackVersion)
