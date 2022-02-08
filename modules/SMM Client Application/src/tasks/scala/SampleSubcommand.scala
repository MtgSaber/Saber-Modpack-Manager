import picocli.CommandLine
import picocli.CommandLine.{Command, Option, Parameters}

import java.util.concurrent.Callable

/**
 * An example of using PicoCLI framework. TODO: remove before release.
 */

@Command(
  name = "bar",
  subcommands = Array(classOf[SampleSubSubCommand]),
  description = Array("A sub-command of foo."),
)
class SampleSubcommand extends Callable[Int] {
  def call(): Int = {
    println("Hello from bar")
    0
  }
}
