package net.mtgsaber.smm.client.models;

import java.util.UUID;

public record Modpack(
        UUID modpackID,
        String name,
        String description,
        Author author,
        URI icon,
) {
}
