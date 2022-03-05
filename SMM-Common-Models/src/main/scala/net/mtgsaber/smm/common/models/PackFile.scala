package net.mtgsaber.smm.common.models

/**
 * A specific file required for a modpack version, including local path relative to pack installation root,
 * and URI of remote source content.
 */
case class PackFile(sourceURI: String, localPath: String)
