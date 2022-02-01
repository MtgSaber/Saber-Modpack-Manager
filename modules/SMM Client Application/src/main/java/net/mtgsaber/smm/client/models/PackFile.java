package net.mtgsaber.smm.client.models;

import java.nio.file.Path;

/**
 *
 */
public record PackFile(
        UUID packFileID,
        Path relativePath,
) {
}
