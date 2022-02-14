import processing.core._
import processing.event.{KeyEvent, MouseEvent}

class Defence extends PApplet {
  var time: Long = System.currentTimeMillis
  var tTick = 0

  override def setup(): Unit = {}

  override def settings(): Unit = {
    fullScreen()
  }

  override def draw(): Unit = {
    background(100, 100, 100)

    World.terrain.foreach(terrain => terrain.draw(this))
    World.squadList.foreach(squad => squad.draw(this))
    updateTick()
  }
  def updateTick(): Unit = {
    val currentTime = System.currentTimeMillis
    if (currentTime > time + 100) {
      tTick = (tTick + 1) % 10
      time = currentTime
      println(World.selectedUnits)
    }
  }
  def spawnFoe(): Unit = {
    World.squadList = Squad(10, 4, Location(2, 2), 1) :: World.squadList
  }

  override def mousePressed(event: MouseEvent): Unit = {

    if (
      event.isShiftDown && !World.selectedUnits.contains(
        World.findSquad(
          Location(mouseX / 16, mouseY / 16)
        )
      ) && World.findSquad(
        Location(mouseX / 16, mouseY / 16)
      ) != null
    ) {
      World.selectedUnits = World.findSquad(
        Location(mouseX / 16, mouseY / 16)
      ) :: World.selectedUnits
    } else if (
      !event.isShiftDown && World.findSquad(
        Location(mouseX / 16, mouseY / 16)
      ) != null
    ) {
      World.selectedUnits =
        World.findSquad(Location(mouseX / 16, mouseY / 16)) :: Nil
    }
  }
}
object Defence extends App {
  PApplet.main(classOf[Defence])

}
