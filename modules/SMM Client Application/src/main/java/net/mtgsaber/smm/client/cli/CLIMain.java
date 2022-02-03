package net.mtgsaber.smm.client.cli;

import net.mtgsaber.smm.client.cli.commands.Hello;
import picocli.CommandLine;
import scala.AnyVal;
import scala.Array;

public class CLIMain {
    public static void main(String[] args) {
        CommandLine.call(new Hello(), args);
    }
}
