package net.mtgsaber.smm.client.cli;

import net.mtgsaber.smm.client.cli.commands.CLIMain;
import org.tinylog.configuration.Configuration;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Entry point for CLI. Redirects to a scala class.
 */
public class CLIMainEntry {
    public static void main(String[] args) {
        System.exit(CLIMain.main(args));
    }
}
