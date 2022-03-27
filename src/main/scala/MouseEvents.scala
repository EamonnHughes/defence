import processing.core.PApplet
import processing.event.MouseEvent

object MouseEvents {

  var dragStart: Option[Location] = None
  var dragEnd: Option[Location] = None

  def mousePressed(event: MouseEvent, p: PApplet): Unit = {
    val mouseButton = event.getButton
    val mouseX = event.getX
    val mouseY = event.getY
    dragStart = Some(Location(mouseX, mouseY))
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
  def mouseDragged(event: MouseEvent): Unit = {
    val mouseX = event.getX
    val mouseY = event.getY

    dragEnd = Some(Location(mouseX, mouseY))
  }
  def dragDraw(p: PApplet): Unit = {
    for {
      start <- dragStart
      end <- dragEnd
    } {
      p.fill(200, 200, 0, 25)
      p.rect(start.x, start.y, end.x - start.x, end.y - start.y)
    }
  }
  def mouseReleased: Unit = {
    for {
      start <- dragStart
      end <- dragEnd
    } {
      World.selectedUnits.units = World.squadList.filter(Squad =>
        Squad.location.x * 16 < end.x && Squad.location.x * 16 >= start.x && Squad.location.y * 16 < end.y && Squad.location.y * 16 >= start.y
      )
    }
    dragStart = None
    dragEnd = None

  }
}
