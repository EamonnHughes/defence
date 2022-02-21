case class Projectile(
    location: Location,
    damage: Int,
    delta: Delta,
    target: Location
) {
  def moveProjectile: Unit = {}
}
