import processing.core.PApplet

class Squad(
    nOfUnits: Int,
    morale: Int,
    location: Location,
    side: Int
) {
  def draw(p: PApplet): Unit = {
    p.fill(255, 0, 0)
    p.rect(location.x * 16, location.y * 16, 16, 16)
  }

}
