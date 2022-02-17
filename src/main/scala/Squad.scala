import processing.core.PApplet

case class Squad(
    var nOfUnits: Int,
    var morale: Int,
    var location: Location,
    var side: Int,
    var destination: Location
) {
  var pathFromDest = Navigation.findPath(location, destination)
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
  def moveSquad: Unit = {
    val movX = math.signum(destination.x - location.x)
    val movY = math.signum(destination.y - location.y)
    var newLoc = Location(location.x + movX, location.y + movY)
    // if empty
    location = newLoc

  }

}
