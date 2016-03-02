package furrygiggle

import org.scalajs.dom
import org.scalajs.dom._
import org.scalajs.dom.html

import scala.scalajs.js.JSApp

object Main extends JSApp {

  def main(): Unit = {
    val doc = dom.document
    val root = doc.getElementById("root")
    val canvas = doc.createElement("canvas").asInstanceOf[html.Canvas]
    root.appendChild(canvas)
    new FurryCanvas(canvas).draw()
  }

}

case class FurryCanvas(canvas: html.Canvas) {

  canvas.width = dom.window.innerWidth
  canvas.height = dom.window.innerHeight - 50

  val context = canvas.getContext("2d").asInstanceOf[CanvasRenderingContext2D]

  def draw(): Unit = {
    context.clearRect(0, 0, canvas.width, canvas.height)
    context.fillStyle = "rgb(255, 150, 150)"
    context.fillRect(30, 30, 100, 100)
  }
}
