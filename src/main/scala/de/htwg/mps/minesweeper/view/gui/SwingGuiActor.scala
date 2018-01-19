package de.htwg.mps.minesweeper.view.gui

import akka.actor.{Actor, ActorRef}
import de.htwg.mps.minesweeper.api.events.{GameEvent, RegisterObserver}

class SwingGuiActor(controller: ActorRef, publisher: ActorRef) extends Actor {

  private val guiController = new GuiController(controller)
  new GameGui(guiController)

  publisher ! RegisterObserver

  override def receive: Receive = {
    case event: GameEvent => guiController.sendEvent(event)
  }

}
