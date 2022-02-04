package net.mtgsaber.smm.client.cli.commands

import picocli.CommandLine
import picocli.CommandLine.{Command, Option, Parameters}

import java.util.concurrent.Callable

/**
 * An example of using PicoCLI framework. TODO: remove before release.
 */
@Command(
  name="hello",
  description = Array("Says hello to the name provided."),
)
class Hello extends Callable[Int] {
  @Parameters(index = "0", description = Array("The name of the receiver of this greeting."))
  private var name: String = "USER"

  @Option(names = Array("-e", "--enthusiasm"), description = Array("adds enthusiasm to the greeting."))
  private var enthusiasm = false

  def call(): Int = {
    println(if enthusiasm then s"Hello, $name!" else s"Hello, $name.")
    0
  }
}
