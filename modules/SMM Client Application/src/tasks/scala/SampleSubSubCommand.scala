import picocli.CommandLine.Command

import java.util.concurrent.Callable

@Command(
  name = "foobar",
  description = Array("A subcommand of bar.")
)
class SampleSubSubCommand extends Callable[Int] {
  override def call(): Int = {
    println("Hello from foobar")
    0
  }
}
