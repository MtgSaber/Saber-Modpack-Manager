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
        Configuration.set("writer", "file");
        Configuration.set("writer.file", "./SMM-Client-Application/TestRun_[" + getTimestamp("yyyy.MM.dd.HH.mm") + "].log");
        Configuration.set("writer.format", "[{date: HH:mm:ss.SSS}][{uptime}][{thread}][{level}]: {message}");
        System.exit(CLIMain.main(args));
    }

    // TODO: move this to Scala and either provide or find an enumeration of patterns. Choose an ISO-8601 pattern as default.
    public static String getTimestamp(String pattern) {
        return ZonedDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }
}
