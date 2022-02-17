import sun.security.ec.point.ProjectivePoint.Mutable

import scala.collection.mutable

object Navigation {
  def makePaths(start: Location, finish: Location): Path = {
    var visitedCells = mutable.Set.empty[Location]
    var paths = List(Path(List(start)))

  }

  def extendPaths(path: Path, visCells: List[Location]): List[Path] = {}

}
