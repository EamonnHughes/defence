import processing.core.PApplet
import processing.event.MouseEvent

object MouseEvents {
  def mousePressed(event: MouseEvent, p: PApplet): Unit = {
    val mouseButton = event.getButton
    val mouseX = event.getX
    val mouseY = event.getY
    if (mouseButton == 39) {
      World.selectedUnits.setDestinations(p)
    }
    if (mouseButton == 37) {

      if (
        event.isShiftDown && !World.selectedUnits.units.contains(
          World.findSquad(
            Location(mouseX / 16, mouseY / 16)
          )
        ) && World.findSquad(
          Location(mouseX / 16, mouseY / 16)
        ) != null
      ) {
        World.selectedUnits.units = World.findSquad(
          Location(mouseX / 16, mouseY / 16)
        ) :: World.selectedUnits.units
      } else if (
        !event.isShiftDown && World.findSquad(
          Location(mouseX / 16, mouseY / 16)
        ) != null
      ) {
        World.selectedUnits.units =
          World.findSquad(Location(mouseX / 16, mouseY / 16)) :: Nil
      } else if (
        World.findSquad(
          Location(mouseX / 16, mouseY / 16)
        ) == null
      ) {
        World.selectedUnits.units = Nil
      }
    }
  }
  def mouseDragged(event: MouseEvent, p: PApplet): Unit = {}
}
