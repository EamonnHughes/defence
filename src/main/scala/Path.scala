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
  def extendPaths(visCells: mutable.Set[Location]): List[Path] = {
    for {
      loc <- getHead.findAdjacents
      if visCells.add(loc)
      if World.terrain.exists(room => room.isInRoom(loc))
      if World.walls.forall(wall => wall.checkOutSide(loc))
      if World.unselectedUnits.units.forall(unit => unit.location != loc)
      if !World.selectedUnits.units.exists(unit => unit.destination == loc)
    } yield add(loc)
  }
}
