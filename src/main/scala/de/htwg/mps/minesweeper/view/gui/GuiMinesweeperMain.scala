package de.htwg.mps.minesweeper.view.gui


import akka.actor.{ActorRef, ActorSystem, Props}

import scala.swing.SwingApplication

object GuiMinesweeperMain extends SwingApplication {

  override def startup(args: Array[String]): Unit = {
    implicit val actorSystem: ActorSystem = ActorResolver.createSystem()

    val actorResolver: ActorResolver = ActorResolver.resolver()

    val publisher: ActorRef = actorResolver.resolvePublisher()

    val gameController: ActorRef = actorResolver.resolveGameController()

    actorSystem.actorOf(Props(new SwingGuiActor(gameController, publisher)))
  }
}
