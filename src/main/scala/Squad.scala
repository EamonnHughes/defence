import processing.core.PApplet

case class Squad(
    nOfUnits: Int,
    morale: Int,
    location: Location,
    side: Int
) {
  def draw(p: PApplet): Unit = {
    if (side == 0) {
      p.fill(0, 255, 0)
    } else {
      p.fill(255, 255, 0)
    }
    p.rect(location.x * 16, location.y * 16, 16, 16)
  }

}
