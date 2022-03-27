import processing.core.PApplet

case class Squadgroup(
    var formationPoints: List[Location],
    var units: List[Squad],
    var destination: Location
) {

  def setDestinations(p: PApplet): Unit = {
    val dest = Location((p.mouseX / 16).floor.toInt, (p.mouseY / 16).ceil.toInt)
    val ll = Spiral.lazyList(dest)
    if (
      World.walls.forall(wall => wall.checkOutside(dest)) && World.terrain
        .exists(room => room.isInRoom(dest))
    ) {
      formationPoints = ll
        .filter(loc => World.terrain.exists(room => room.isInRoom(loc)))
        .take(units.length)
        .toList
      for (i <- 0 until units.length) {
        units(i).destination = formationPoints(i)
      }
    } else {}

  }

}
