import processing.core.PApplet

case class Squadgroup(
    var formationPoints: List[Location],
    var Units: List[Squad],
    var Destination: Location
) {
  def formUp: Unit = {}
  def setDestinations(p: PApplet): Unit = {
    var dest = Location((p.mouseX / 16).floor.toInt, (p.mouseY / 16).ceil.toInt)
    var adjs = dest.findAdjacents

  }

}
