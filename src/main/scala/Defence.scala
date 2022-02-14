import processing.core._
import processing.event.{KeyEvent, MouseEvent}

class Defence extends PApplet {
  var time: Long = System.currentTimeMillis
  var tTick = 0

  override def setup(): Unit = {}

  override def settings(): Unit = {
    size(1024, 1024)
  }

  override def draw(): Unit = {
    background(100, 100, 100)

    World.terrain.foreach(terrain => terrain.draw(this))
    World.squadList.foreach(squad => squad.draw(this))
    World.navigableLocations = for {
      x <- (0 until 64).toList
      y <- (0 until 64).toList
      if (World.terrain.exists(room =>
        x < room.location.x + room.dstx && x >= room.location.x && y < room.location.y + room.dstx && y >= room.location.y
      )
      )
    } yield Location(x, y)
    World.navigableLocations.foreach(loc => rect(loc.x * 16, loc.y * 16, 1, 1))
    updateTick()
  }
  def updateTick(): Unit = {
    val currentTime = System.currentTimeMillis
    if (currentTime > time + 100) {
      tTick = (tTick + 1) % 10
      time = currentTime
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
    } else if (
      World.findSquad(
        Location(mouseX / 16, mouseY / 16)
      ) == null
    ) {
      World.selectedUnits = Nil
    }
  }
}
object Defence extends App {
  PApplet.main(classOf[Defence])

}
