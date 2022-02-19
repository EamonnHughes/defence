object World {
  var squadList =
    List(
      Squad(10, 4, Location(16, 16), 0, Location(16, 16)),
      Squad(10, 4, Location(16, 14), 0, Location(16, 14)),
      Squad(10, 4, Location(16, 12), 0, Location(16, 12)),
      Squad(10, 4, Location(16, 10), 0, Location(16, 10)),
      Squad(10, 4, Location(16, 8), 0, Location(16, 8)),
      Squad(10, 4, Location(16, 6), 0, Location(16, 6)),
      Squad(10, 4, Location(16, 15), 0, Location(16, 15)),
      Squad(10, 4, Location(16, 13), 0, Location(16, 13)),
      Squad(10, 4, Location(16, 11), 0, Location(16, 11)),
      Squad(10, 4, Location(16, 9), 0, Location(16, 9)),
      Squad(10, 4, Location(16, 7), 0, Location(16, 7)),
      Squad(10, 4, Location(16, 5), 0, Location(16, 5))
    )

  var terrain = List(
    Room(Location(2, 2), 16, 16),
    Room(Location(18, 3), 2, 1),
    Room(Location(20, 2), 16, 16)
  )

  var selectedUnits = List.empty[Squad]
  var unselectedUnits = List.empty[Squad]
  def findSquad(location: Location): Squad = { // null
    squadList.find(thing => thing.location == location).orNull
  }
  var navigableLocations = List.empty[Location]

}
