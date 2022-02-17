import scala.collection.mutable

case class Path(points: List[Location]) {
  def getHead: Location = {
    points.head
  }
  def add(location: Location): Path = {
    Path(location :: points)
  }
  def extendPaths(visCells: mutable.Set[Location]): List[Path] = {
    for {
      loc <- getHead.findAdjacents
      if visCells.add(loc)
      if World.terrain.exists(room => room.isInRoom(loc))
    } yield add(loc)
  }
}
