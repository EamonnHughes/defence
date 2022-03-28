import processing.core.PApplet

object UserInterface {
  val numOfButtons = 8
  def draw(p: PApplet): Unit = {
    p.fill(255, 255, 255)
    p.rect(0, 0, (32 * numOfButtons) + (16 * (numOfButtons + 1)), 64)
    for (i <- 0 until numOfButtons) {
      p.fill(25, 25, 25)
      p.rect(16 + (48 * (i)), 16, 32, 32)
    }
  }
}
