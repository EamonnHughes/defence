import processing.core.PApplet

case class Projectile(
    var location: Location,
    damage: Int,
    var delta: Delta,
    target: Location
) {
  def moveProjectile: Unit = {
    location = delta.moveByDelta(location)
  }
  def draw(p: PApplet): Unit = {
    p.fill(255, 75, 0)
    p.ellipse(location.x * 16, location.y * 16, 8, 8)
  }
  def setDelta: Unit = {}
}
