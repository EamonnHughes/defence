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
}
