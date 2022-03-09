import processing.core.PApplet

case class Projectile(
    var location: Location,
    var delta: Delta,
    damage: Int
) {
  def moveProjectile: Unit = {
    location = location + delta
  }
  def draw(p: PApplet): Unit = {
    p.fill(255, 75, 0)
    p.ellipse(location.x * 16, location.y * 16, 4, 4)
  }
  def checkForHit: Unit = {
    var hUnits = World.squadList.find(squad => squad.contains(location))
    for (unit <- hUnits) {
      unit.health -= 1
      World.projectileList = World.projectileList.filterNot(p => p == this)
    }
  }
}

object Projectile {
  def apply(location: Location, target: Location, damage: Int): Projectile = {
    val delta = Delta(
      (target.x - location.x) / location.distanceFrom(target),
      (target.y - location.y) / location.distanceFrom(target)
    )
    Projectile(location, delta, damage)
  }

}
