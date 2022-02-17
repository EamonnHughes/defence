case class Location(x: Int, y: Int) {
  def findAdjacents: List[Location] = {
    val adj = List(
      Location(x, y - 1),
      Location(x, y + 1),
      Location(x - 1, y),
      Location(x + 1, y),
      Location(x - 1, y - 1),
      Location(x - 1, y + 1),
      Location(x + 1, y - 1),
      Location(x + 1, y + 1)
    )
    adj
  }
}
