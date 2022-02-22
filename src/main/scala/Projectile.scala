import processing.core.PApplet

case class Projectile(
    var startX: Int,
    var startY: Int,
    var locationX: Int,
    var locationY: Int,
    damage: Int,
    var deltaX: Int,
    var deltaY: Int,
    targetX: Int,
    targetY: Int
) {
  def moveProjectile: Unit = {
    locationX += deltaX
    locationY += deltaY
  }
  def draw(p: PApplet): Unit = {
    p.fill(255, 75, 0)
    p.ellipse(locationX, locationY, 4, 4)
  }
  def setDelta: Unit = {
    deltaX = 1 - 1 / (targetX - startX)
    deltaY = 1 - 1 / (targetY - startY)
  }
}
