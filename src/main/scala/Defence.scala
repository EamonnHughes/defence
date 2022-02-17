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

    fill(255, 0, 0)

    World.terrain.foreach(terrain => terrain.draw(this))
    for {
      path <- Navigation.findPath(Location(16, 16), Location(30, 16))
      loc <- path.points
    } {
      fill(255, 0, 0)
      rect(loc.x * 16, loc.y * 16, 16, 16)
    }
    World.squadList.foreach(squad => squad.draw(this))
    World.navigableLocations = for {
      x <- (0 until 64).toList
      y <- (0 until 64).toList
      if World.terrain.exists(room => room.isInRoom(Location(x, y)))

    } yield Location(x, y)
    fill(255, 0, 255, 25)
    noStroke()
    World.navigableLocations.foreach(loc =>
      rect(loc.x * 16, loc.y * 16, 16, 16)
    )

    updateTick()
  }
  override def mousePressed(event: MouseEvent): Unit = {

    World.selectedUnits.foreach(unit =>
      unit.destination =
        Location((mouseX / 16).floor.toInt, (mouseY / 16).ceil.toInt)
    )
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

  def updateTick(): Unit = {
    val currentTime = System.currentTimeMillis
    if (currentTime > time + 100) {
      tTick = (tTick + 1) % 10
      time = currentTime
    }
  }
  def spawnFoe(): Unit = {
    World.squadList =
      Squad(10, 4, Location(2, 2), 1, Location(2, 2)) :: World.squadList
  }

}
object Defence extends App {
  PApplet.main(classOf[Defence])

}
