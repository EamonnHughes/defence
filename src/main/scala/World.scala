object World {
  var squadList =
    List(
      Squad(10, 4, Location(16, 16), 0, Location(16, 16)),
      Squad(10, 4, Location(16, 14), 0, Location(16, 14)),
      Squad(10, 4, Location(16, 12), 0, Location(16, 12))
    )

  var terrain = List(
    Room(Location(2, 2), 16, 16),
    Room(Location(18, 3), 2, 1),
    Room(Location(20, 2), 16, 16)
  )

  var selectedUnits = List.empty[Squad]
  def findSquad(location: Location): Squad = { // null
    squadList.find(thing => thing.location == location).orNull
  }
  var navigableLocations = List.empty[Location]

}
