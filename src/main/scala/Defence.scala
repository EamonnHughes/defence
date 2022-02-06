import processing.core._
import processing.event.{KeyEvent, MouseEvent}

class Defence extends PApplet {

  val BoardWidth = 1024
  val BoardHeight = 512
  override def setup(): Unit = {}

  override def settings(): Unit = {
    size(BoardWidth, BoardHeight)
  }

  override def draw(): Unit = {
    background(100, 100, 100)
  }
}
object Defence extends App {
  PApplet.main(classOf[Defence])

}
