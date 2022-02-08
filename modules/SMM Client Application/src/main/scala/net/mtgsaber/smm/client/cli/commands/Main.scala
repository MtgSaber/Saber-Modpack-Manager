package net.mtgsaber.smm.client.cli.commands

import picocli.CommandLine
import picocli.CommandLine.{Command, Option, Parameters}

import java.util.concurrent.Callable

@Command(
  name="smm",
  subcommands = Array(
    classOf[InstallModpack],
  ),
  description = Array("The root command of the Saber Modpack Manager. Should be followed by a subcommand."),
  mixinStandardHelpOptions = true,
)
class Main extends Callable[Int] {
  @CommandLine.Spec
  private[commands] var spec: CommandLine.Model.CommandSpec = null

  // TODO: add options and annotate them.

  private var isConfigLoaded = false

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

  protected[commands] def loadConfig(): Unit = {
    if !isConfigLoaded then {
      // TODO: load config
      isConfigLoaded = true
    }
  }
}

object Main {
  def main(args: Array[String]): Int = {
    CommandLine.call(new Main(), args*)
  }
}
