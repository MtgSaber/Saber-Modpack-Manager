package net.mtgsaber.smm.client.cli.commands

import net.mtgsaber.smm.client.state.{ApplicationConfig, ApplicationState}
import net.mtgsaber.smm.client.util.Temporal
import org.tinylog.configuration.Configuration
import picocli.CommandLine
import picocli.CommandLine.{Command, Option, Parameters}

import java.util.concurrent.Callable

@Command(
  name="smm",
  subcommands = Array(
    classOf[InstallModpack.Command],
  ),
  description = Array("The root command of the Saber Modpack Manager. Should be followed by a subcommand."),
  mixinStandardHelpOptions = true,
)
class CLIMain extends Callable[Int] {
  @CommandLine.Spec
  private[commands] var spec: CommandLine.Model.CommandSpec = null

  def call(): Int = {
    // TODO: during GUI development, change this method to code that launches the GUI.
    if spec == null then throw NullPointerException(
      "Internal library error. Please report an issue through the appropriate channels."
    )
    else throw new CommandLine.ParameterException(
      spec.commandLine(),
      "Until the GUI feature of this software is released, please specify a subcommand or use --help."
    )
  }
}

object CLIMain {
  def main(args: Array[String]): Int = {
    Configuration.set("writer", "file")
    Configuration.set("writer.file", "./SMM-Client-Application/tmp/logs/TestRun_[" + Temporal.timestamp() + "].log")
    Configuration.set("writer.format", "[{date: HH:mm:ss.SSS}][{uptime}][{thread}][{level}]: {message}")
    val commandLine: CommandLine = new CommandLine(new CLIMain())
    commandLine.execute(args*)
  }
}
