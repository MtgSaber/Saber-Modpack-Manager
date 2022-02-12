package net.mtgsaber.smm.client.cli;

import net.mtgsaber.smm.client.cli.commands.Hello;
import net.mtgsaber.smm.client.cli.commands.Main;
import org.tinylog.configuration.Configuration;
import picocli.CommandLine;

/**
 * Entry point for CLI. Redirects to a scala class.
 */
public class CLIMain {
    public static void main(String[] args) {
        Configuration.set("writer", "file");
        Configuration.set("writer.file", "logs/Experiment[" + getTimestamp("yyyy.MM.dd.HH.mm") + "].log");
        Configuration.set("writer.format", "[{date: HH:mm:ss.SSS}][{uptime}][{thread}][{level}]: {message}");
        System.exit(Main.main(args));
    }
}