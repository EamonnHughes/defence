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
    destination = loc
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

  for {
    i <- 1 to 10
  } {
    println(i)
  }

  val result = for {
    i <- (1 to 10).toList
    if i % 2 == 0
  } yield i
  def contains(elocation: Location): Boolean = {
    if (
      elocation.x >= this.location.x * 16 && elocation.x < this.location.x * 16 + 16 && elocation.y >= this.location.y * 16 && elocation.y < this.location.y * 16 + 16
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

}

object Squad {
  var Trawler: PImage = _
  def loadImages(p: PApplet): Unit = {
    Trawler = p.loadImage("src/main/Resources/Trawler.png")

  }
}
