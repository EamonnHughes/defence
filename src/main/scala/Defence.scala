import processing.core._
import processing.event.{KeyEvent, MouseEvent}

class Defence extends PApplet {
  var time: Long = System.currentTimeMillis
  var tTick = 0

  val BoardWidth = 1024
  val BoardHeight = 512
  override def setup(): Unit = {}

  override def settings(): Unit = {
    size(BoardWidth, BoardHeight)
  }

  override def draw(): Unit = {
    background(100, 100, 100)

    World.terrain.foreach(terrain => terrain.draw(this))
    World.squadList.foreach(squad => squad.draw(this))
    updateTick()
  }
  def updateTick(): Unit = {
    var currentTime = System.currentTimeMillis
    if (currentTime > time + 100) {
      tTick = (tTick + 1) % 10
      time = currentTime
    }
  }
}
object Defence extends App {
  PApplet.main(classOf[Defence])

}
