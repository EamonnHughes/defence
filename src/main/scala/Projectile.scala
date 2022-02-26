import processing.core.PApplet

case class Projectile(
    var location: Location,
    damage: Int,
    var delta: Delta,
    target: Location
) {
  def moveProjectile: Unit = {
    location = location + delta
  }
  def draw(p: PApplet): Unit = {
    p.fill(255, 75, 0)
    p.ellipse(location.x, location.y, 4, 4)
  }
  def setDelta: Unit = {
    delta = Delta(
      (target.x - location.x) / location.distanceFrom(target),
      (target.y - location.y) / location.distanceFrom(target)
    )
  }
}
