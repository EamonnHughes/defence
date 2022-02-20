case class Spiral(var location: Location) {

  var nextInterval = 1
  var currentTick = 0
  var delta = Delta(0, 1)
  def next: Location = {
    val oLoc = location
    location = location + delta
    currentTick += 1
    if (currentTick == nextInterval) {
      currentTick = 0
      delta = delta.rotate
      if (delta.dx == 0) {
        nextInterval += 1
      }

    }
    oLoc
  }
}

object Spiral {
  def lazyList(location: Location): LazyList[Location] = {
    val spiral = Spiral(location)
    LazyList.continually(spiral.next)
  }

  val ll = Spiral.lazyList(Location(0, 0))

  ll.filter(loc => loc.x > 0).take(4).toList
}
