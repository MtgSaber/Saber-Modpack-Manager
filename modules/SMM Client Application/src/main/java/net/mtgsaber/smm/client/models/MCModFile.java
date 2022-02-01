package net.mtgsaber.smm.client.models;

import java.net.URI;
import java.nio.file.Path;

/**
 *
 */
public record MCModFile(
        MCMod mod,
        Path relativePath,
        URI downloadURI,
) {
}
