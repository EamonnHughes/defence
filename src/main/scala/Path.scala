import scala.collection.mutable

case class Path(points: List[Location]) {
  def getHead: Location = {
    points.head
  }
  def tail: Option[Path] = {
    if (points.length > 1) {
      Some(Path(points.tail))
    } else {
      None
    }

  }
  def add(location: Location): Path = {
    Path(location :: points)
  }
  def extendPaths(visCells: mutable.Set[Location], unit: Squad): List[Path] = {
    var unitsExcluding =
      World.unselectedUnits.units.filterNot(squad => squad == unit)
    for {
      loc <- getHead.findAdjacents
      if visCells.add(loc)
      if World.terrain.exists(room => room.isInRoom(loc))
      if World.walls.forall(wall => wall.checkOutside(loc))
      if unitsExcluding.forall(squad => squad != loc)
      if World.squadList.forall(unit => unit.destination != loc)
    } yield add(loc)
  }
}
