package de.htwg.mps.minesweeper.view.gui

import java.awt.Color
import javax.swing.border.Border

import scala.swing.{Dimension, Font, Swing}

object Constants {
  val hiddenBgColor: Color = new Color(177, 177, 177)
  val cellBorder: Border = Swing.LineBorder(hiddenBgColor)
  val cellSize: Dimension = new Dimension(40, 40)
  val headingFont = new Font("Arial", 0, 20)
  val cellFont = new Font("Verdana", 1, 28)
  val nullColor: Color = Color.lightGray
  val bombColor: Color = new Color(255, 102, 0)
  var textColor: Color = Color.black
  var flagColor: Color = Color.black
  var questionColor: Color = Color.black

}
