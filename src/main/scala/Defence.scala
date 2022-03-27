import processing.awt.PGraphicsJava2D
import processing.core._
import processing.event.{KeyEvent, MouseEvent}
import processing.opengl.PGraphicsOpenGL

class Defence extends PApplet {
  var time: Long = System.currentTimeMillis
  var tTick = 0

  override def setup(): Unit = {
    Squad.loadImages(this)
  }

  override def settings(): Unit = {
    size(1024, 1024)
    noSmooth()
  }

  override def draw(): Unit = {
    World.unselectedUnits.units = World.squadList.filterNot(Squad =>
      World.selectedUnits.units.contains(Squad)
    )
    background(100, 100, 100)
    World.terrain.foreach(terrain => terrain.draw(this))
    fill(0, 0, 0)
    World.selectedUnits.formationPoints.foreach(point =>
      rect(point.x * 16, point.y * 16, 2, 2)
    )
    fill(255, 0, 0, 50)
    World.squadList.foreach(squad => squad.draw(this))
    World.squadList.foreach(squad => squad.navigateTo(squad.destination))
    World.navigableLocations = for {
      x <- (0 until 64).toList
      y <- (0 until 64).toList
      if World.terrain.exists(room => room.isInRoom(Location(x, y)))
    } yield Location(x, y)
    fill(255, 0, 255, 25)
    noStroke()
    World.walls.foreach(wall => wall.draw(this))
    World.projectileList.foreach(proj => proj.draw(this))
    MouseEvents.dragDraw(this)
    updateTick()
  }
  override def mousePressed(event: MouseEvent): Unit = {
    MouseEvents.mousePressed(event, this)
  }
  override def mouseDragged(event: MouseEvent): Unit = {
    MouseEvents.mouseDragged(event)
  }
  override def mouseReleased(event: MouseEvent): Unit = {
    MouseEvents.mouseReleased
  }

  def updateTick(): Unit = {
    val currentTime = System.currentTimeMillis
    if (currentTime > time + 100) {
      tTick = (tTick + 1) % 10
      time = currentTime
      World.squadList.foreach(squad => squad.moveSquad())
      World.squadList = World.squadList.filter(unit => unit.health > 0)
      World.projectileList.foreach(proj => proj.moveProjectile)
      World.projectileList.foreach(p => p.checkForHit)
      World.projectileList.foreach(p => p.tick += 1)
    }
    if (tTick % 5 == 0) {
      World.squadList.foreach(squad => squad.fireOnFoes)
    }
  }
}
object Defence extends App {
  PApplet.main(classOf[Defence])

}
