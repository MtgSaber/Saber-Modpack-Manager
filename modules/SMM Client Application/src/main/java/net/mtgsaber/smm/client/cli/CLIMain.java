package net.mtgsaber.smm.client.cli;

import net.mtgsaber.smm.client.cli.commands.Hello;
import net.mtgsaber.smm.client.cli.commands.Main;
import picocli.CommandLine;

/**
 * Entry point for CLI. Redirects to a scala class.
 */
public class CLIMain {
    public static void main(String[] args) {
        System.exit(Main.main(args));
    }
}
