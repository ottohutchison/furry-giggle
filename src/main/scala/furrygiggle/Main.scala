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
    new FurryCanvas(canvas)
  }

}

case class FurryCanvas(canvas: html.Canvas) {

  canvas.width = dom.window.innerWidth
  canvas.height = dom.window.innerHeight - 50

  val context = canvas.getContext("2d").asInstanceOf[CanvasRenderingContext2D]

  println()
  canvas.addEventListener[dom.MouseEvent]("mousedown", (event: dom.MouseEvent) => {
    val rect = canvas.getBoundingClientRect()
    // translate the incoming event coordinates so that they start at (0,0) in top left corner of canvas
    val p = (
      event.clientX.toInt - rect.left.toInt,
      event.clientY.toInt - rect.top.toInt)
    draw(p)
  })

  import context._


  def draw(p: (Int,Int)): Unit = {
    val (x, y) = p
    //    clearRect(0, 0, canvas.width, canvas.height)
    fillStyle = "rgb(0, 150, 150)"
    fillRect(p._1, p._2, 200, 100)

    moveTo(x+200,y+50)
    bezierCurveTo(x+80,y+80,x+300,y+300,x+100,y)
    fillStyle = "rgb(60, 100, 50)"
    fill()
  }
}