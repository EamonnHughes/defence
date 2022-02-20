case class Spiral(var location: Location) {

  var nextInterval = 1
  var currentTick = 0
  var delta = Delta(0, 1)
  def next: Location = {
    location = location + delta
    currentTick += 1
    if (currentTick == nextInterval) {
      currentTick = 0
      delta = delta.rotate
      if (delta.dx == 0) {
        nextInterval += 1
      }

    }
    location

  }
}
