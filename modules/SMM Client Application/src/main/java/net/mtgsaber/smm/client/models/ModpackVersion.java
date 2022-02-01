package net.mtgsaber.smm.client.models;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public record ModpackVersion(
        Modpack modpack,
        String version,
        URI changelog,
        String targetMCVersion,
        URI forgeDLPage,
        List<MCModFile> modFiles,
        List<ConfigFile> configFiles,
        List<PackFile> miscPackFiles,
        MCProfile profile
) {
}
