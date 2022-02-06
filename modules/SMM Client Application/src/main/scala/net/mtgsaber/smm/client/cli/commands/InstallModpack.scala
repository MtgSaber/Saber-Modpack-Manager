package net.mtgsaber.smm.client.cli.commands

import picocli.CommandLine.{Command, Option, Parameters}

import java.util.concurrent.Callable
import scala.runtime.Nothing$

class InstallModpack extends Callable[Int] {
  /**
   * Performs the modpack installation process and returns its exit code.
   */
  override def call(): Int = {
    // TODO: implement
    0
  }
}
