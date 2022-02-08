import picocli.CommandLine
import picocli.CommandLine.{Command, Option, Parameters}

import java.util.concurrent.Callable

/**
 * An example of using PicoCLI framework. TODO: remove before release.
 */

@Command(
  name="foo",
  description = Array("A sample command with a subcommand, bar."),
  subcommands = Array(classOf[SampleSubcommand]),
)
class SampleCommand extends Callable[Int] {
  @CommandLine.Spec
  private var spec: CommandLine.Model.CommandSpec = null

  def call(): Int = {
    // TODO: during GUI development, change this method to code that launches the GUI.
    if spec == null then throw NullPointerException("Internal library error. Please report an issue through the appropriate channels.")
    else throw new CommandLine.ParameterException(spec.commandLine(), "Please specify a subcommand or use --help.")
  }
}

object SampleCommand {
  def main(args: Array[String]): Unit = {
    CommandLine.call(new SampleCommand(), args*)
  }
}
