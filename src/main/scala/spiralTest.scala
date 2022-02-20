object spiralTest extends App {
  var location = Location(0, 0)
  var direction = 0
  var nextInterval = 1
  var currentTick = 0
  for (i <- 0 until 20) {
    if (direction == 0) {
      location = Location(location.x, location.y + 1)
    } else if (direction == 1) {
      location = Location(location.x + 1, location.y)
    } else if (direction == 2) {
      location = Location(location.x, location.y - 1)
    } else if (direction == 3) {
      location = Location(location.x - 1, location.y)
    }
    currentTick += 1
    if (currentTick == nextInterval) {
      direction += 1
      currentTick = 0
    }
    if (direction == 2) {
      nextInterval += 1

    } else if (direction == 4) {
      direction = 0

    }
    println(location)
  }

}
