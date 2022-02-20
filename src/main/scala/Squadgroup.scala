import processing.core.PApplet

case class Squadgroup(
    var formationPoints: List[Location],
    var Units: List[Squad],
    var Destination: Location
) {
  def setDestinations(p: PApplet): Unit = {
    formationPoints = List.empty
    val dest = Location((p.mouseX / 16).floor.toInt, (p.mouseY / 16).ceil.toInt)
    val spiral = Spiral(dest)
    for (unit <- Units) {
      formationPoints = spiral.next :: formationPoints
    }

  }

}
