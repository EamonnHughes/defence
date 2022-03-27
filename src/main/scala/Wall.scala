import processing.core.PApplet

case class Wall(
    location: Location,
    width: Int,
    height: Int
) extends Construction {
  def draw(p: PApplet): Unit = {
    p.fill(200, 200, 200)
    p.rect(location.x * 16, location.y * 16, width * 16, height * 16)
  }
  def checkOutSide(loc: Location): Boolean = {
    if (
      loc.x <= location.x + width && loc.x >= location.x && loc.y <= location.y + height && loc.y >= location.y
    ) { false }
    else { true }
  }
}
