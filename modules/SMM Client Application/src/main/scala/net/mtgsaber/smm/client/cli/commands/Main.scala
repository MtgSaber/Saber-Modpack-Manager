package net.mtgsaber.smm.client.cli.commands

import picocli.CommandLine.{Command, Option, Parameters}

import java.util.concurrent.Callable

@Command(
  name="saber-mm",
  subcommands = Array(
    // TODO: fill this with subcommands
  ),
  description = Array("Says hello to the name provided."),
)
class Main extends Callable[Int] {
  def call(): Int = {
    0
  }
}
