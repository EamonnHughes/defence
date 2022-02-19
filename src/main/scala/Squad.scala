import processing.core.PApplet

case class Squad(
    var nOfUnits: Int,
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
    if (World.selectedUnits.contains(this)) {
      p.stroke(255, 255, 0)
    } else {
      p.noStroke()
    }
    p.rect(location.x * 16, location.y * 16, 16, 16)
  }
  def moveSquad(): Unit = {

    println(pathToDest)
    for {
      path <- pathToDest
    } {
      val nextLoc = path.getHead

      location = nextLoc

      pathToDest = path.tail

    }

  }

}
