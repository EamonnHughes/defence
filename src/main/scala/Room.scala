import processing.core.PApplet
case class Room(location: Location, dstx: Int, dsty: Int) {
  def draw(p: PApplet): Unit = {
    p.fill(255, 255, 255)
    p.rect(location.x * 16, location.y * 16, dstx * 16, dsty * 16)
  }
}
