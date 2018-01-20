package de.htwg.mps.minesweeper.view.gui

import java.awt.event.MouseEvent

import de.htwg.mps.minesweeper.api.events.GridModel

import scala.swing.event.MouseClicked
import scala.swing.{Alignment, BoxPanel, FlowPanel, Label, Orientation}

class CellPanel(row: Int, col: Int, grid: GridModel, guiController: GuiController) extends FlowPanel {
  vGap = 2
  hGap = 2

  contents += new BoxPanel(Orientation.Vertical) {
    border = Constants.cellBorder

    contents += new FlowPanel() {
      vGap = 0
      hGap = 0

      contents += new Label() {
        preferredSize = Constants.cellSize
        horizontalAlignment = Alignment.Center
        verticalAlignment = Alignment.Center
        font = Constants.cellFont
        listenTo(mouse.clicks)
        listenTo(mouse.moves)
        listenTo(guiController)
        background = Constants.hiddenBgColor

        updateCell(grid.fields(row)(col).value)

        private def updateCell(value: String): Unit = {
          text = value match {
            case "~" => ""
            case "0" => ""
            case t => t
          }
          foreground = value match {
            case "+" => Constants.bombColor
            case "#" => Constants.flagColor
            case "?" => Constants.questionColor
            case _ => Constants.textColor
          }
          opaque = value match {
            case "~" => true
            case "#" => true
            case "?" => true
            case _ => false
          }
          repaint
        }

        reactions += {
          case e: FieldUpdateEvent =>
            if (e.col == col && e.row == row) {
              updateCell(e.field.value)
            }
          case e: GridUpdateEvent =>
            if (e.grid.fields.lengthCompare(row) > 0 && e.grid.fields(row).lengthCompare(col) > 0) {
              val newFieldValue = e.grid.fields(row)(col).value
              updateCell(newFieldValue)
            }
          case evt@MouseClicked(_, _, _, _, _) =>
            evt.peer.getButton match {
              case MouseEvent.BUTTON1 => guiController.openField(row, col)
              case MouseEvent.BUTTON3 => guiController.toggleMarkField(row, col)
            }
        }

      }

    }
  }

}
