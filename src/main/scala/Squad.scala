import processing.core.{PApplet, PImage}

case class Squad(
    var health: Int,
    var morale: Int,
    var location: Location,
    var side: Int,
    var destination: Location
) {

  var pathToDest = Option.empty[Path]

  def navigateTo(loc: Location): Unit = {
    if (
      World.walls.forall(wall => wall.checkOutside(loc)) && World.terrain
        .exists(room => room.isInRoom(loc))
    ) {
      destination = loc
    } else {
      destination = location
    }
    pathToDest =
      Navigation.findPath(destination, location).flatMap(path => path.tail)
  }

  def draw(p: PApplet): Unit = {

    if (side == 0) {
      p.fill(0, 255, 0)
    } else {
      p.fill(255, 255, 0)

    }
    if (World.selectedUnits.units.contains(this)) {
      p.stroke(255, 255, 0)
    } else {
      p.noStroke()
    }
    p.rect(location.x * 16, location.y * 16, 16, 16)
    p.image(Squad.Trawler, location.x * 16, location.y * 16, 16, 16)
  }

  def moveSquad(): Unit = {
    println(pathToDest)
    for {
      path <- pathToDest
    } {
      val nextLoc = path.getHead
      if (!World.squadList.exists(squad => squad.location == nextLoc)) {
        location = nextLoc
        pathToDest = path.tail
      }
    }
  }

  def contains(elocation: Location): Boolean = {
    if (
      elocation.x >= this.location.x && elocation.x < this.location.x + 1 && elocation.y >= this.location.y && elocation.y < this.location.y + 1
    ) true
    else false
  }

  def fireOnFoes: Unit = {
    val foes = for {
      eSquad <- World.squadList
      if eSquad.side != side
      if location.distanceFrom(eSquad.location) < 5
    } yield eSquad

    foes.headOption foreach { foe =>
      println("fire on " + foe)
      if (location.distanceFrom(foe.location) == 0) {
        println("ME: " + this)
        println("IT: " + foe)
      }
      World.projectileList =
        Projectile(location, foe.location, 1) :: World.projectileList
    }
  }
  def buildWall: Unit = {}

}

object Squad {
  var Trawler: PImage = _
  def loadImages(p: PApplet): Unit = {
    Trawler = p.loadImage("src/main/Resources/Trawler.png")

  }
}
