object World {
  var squadList =
    List(
      Squad(10, 4, Location(16, 16), 0),
      Squad(10, 4, Location(16, 18), 0),
      Squad(10, 4, Location(16, 20), 0)
    )

  var terrain = List(
    Room(Location(2, 2), 16, 16)
  )

  var selectedUnits = List.empty[Squad]
  def findSquad(location: Location): Squad = { // null
    squadList.find(thing => thing.location == location).orNull
  }

}
