package net.mtgsaber.smm.client.models;

import java.net.URI;

/**
 *
 */
public record MCMod(
        String name,
        URI modPage,
        Author author,
) {
}
