import processing.core.PApplet
case class Room(location: Location, dstx: Int, dsty: Int) {
  def draw(p: PApplet): Unit = {
    p.noStroke()
    p.fill(155, 155, 155)
    p.rect(location.x * 16, location.y * 16, dstx * 16, dsty * 16)

  }
}
