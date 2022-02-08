package net.mtgsaber.smm.client.cli.commands

import picocli.CommandLine.{Command, Option, Parameters, ParentCommand}

import java.util.concurrent.Callable
import scala.runtime.Nothing$

@Command(
  name = "install",
  description = Array("Installs the specified modpack."),
)
class InstallModpack extends Callable[Int] {
  @ParentCommand
  private var parent: Main = null
  
  // TODO: add options and annotate them.

  /**
   * Performs the modpack installation process and returns its exit code.
   */
  override def call(): Int = {
    // TODO: implement
    0
  }
}
