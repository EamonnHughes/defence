import processing.core.PApplet

case class Squadgroup(
    var formationPoints: List[Location],
    var Units: List[Squad],
    var Destination: Location
) {
  def setDestinations(p: PApplet): Unit = {
    val dest = Location((p.mouseX / 16).floor.toInt, (p.mouseY / 16).ceil.toInt)
    var lastLoc = dest
    var nOfT = 1
    var times = 0
    var xOrY = 1
    var posOrNeg = 1
    for (unit <- Units) {
      if (xOrY == 1 && times < nOfT) {
        formationPoints =
          Location(lastLoc.x, lastLoc.y + posOrNeg) :: formationPoints
        times += 1
        if (times == nOfT) {
          times = 0
          xOrY = 0
        }
      } else if (xOrY == 0 && times < nOfT) {
        formationPoints =
          Location(lastLoc.x + posOrNeg, lastLoc.y) :: formationPoints
        times += 1
        if (times == nOfT) {
          times = 0
          xOrY = 1
          posOrNeg = -posOrNeg
        }
      }

    }
  }

}
