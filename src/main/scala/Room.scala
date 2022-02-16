import processing.core.PApplet
case class Room(location: Location, dstx: Int, dsty: Int) {
  def draw(p: PApplet): Unit = {
    p.noStroke()
    p.fill(155, 155, 155)
    p.rect(location.x * 16, location.y * 16, dstx * 16, dsty * 16)

  }
  def isInRoom(loc: Location): Boolean = {
    if (
      loc.x < location.x + dstx && loc.x >= location.x && loc.y < location.y + dsty && loc.y >= location.y
    ) { true }
    else { false }

  }
}
