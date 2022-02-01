package net.mtgsaber.smm.client.models;

import java.nio.file.Path;

/**
 *
 */
public record ConfigFile(
        UUID configID,
        String name,
        Path relativePath,
        MCMod mod,
) {
}
