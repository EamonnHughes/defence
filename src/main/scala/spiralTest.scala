object spiralTest extends App {
  var spiral = Spiral(Location(0, 0))
  for (i <- 0 until 20) {

    println(spiral.next)
  }

}
