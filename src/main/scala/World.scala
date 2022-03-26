object World {
  var squadList = {
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
      Squad(10, 4, Location(16, 5), 0, Location(16, 5)),
      Squad(10, 4, Location(14, 16), 1, Location(14, 16)),
      Squad(10, 4, Location(14, 14), 1, Location(16, 14)),
      Squad(10, 4, Location(14, 12), 1, Location(16, 12)),
      Squad(10, 4, Location(14, 10), 1, Location(16, 10)),
      Squad(10, 4, Location(14, 8), 1, Location(16, 8)),
      Squad(10, 4, Location(14, 6), 1, Location(16, 6)),
      Squad(10, 4, Location(14, 15), 1, Location(16, 15)),
      Squad(10, 4, Location(14, 13), 1, Location(16, 13)),
      Squad(10, 4, Location(14, 11), 1, Location(16, 11)),
      Squad(10, 4, Location(14, 9), 1, Location(16, 9)),
      Squad(10, 4, Location(14, 7), 1, Location(16, 7)),
      Squad(10, 4, Location(17, 16), 0, Location(17, 16)),
      Squad(10, 4, Location(17, 14), 0, Location(17, 14)),
      Squad(10, 4, Location(17, 12), 0, Location(17, 12)),
      Squad(10, 4, Location(17, 10), 0, Location(17, 10)),
      Squad(10, 4, Location(17, 8), 0, Location(17, 8)),
      Squad(10, 4, Location(17, 6), 0, Location(17, 6)),
      Squad(10, 4, Location(17, 15), 0, Location(17, 15)),
      Squad(10, 4, Location(17, 13), 0, Location(17, 13)),
      Squad(10, 4, Location(17, 11), 0, Location(17, 11)),
      Squad(10, 4, Location(17, 9), 0, Location(17, 9)),
      Squad(10, 4, Location(17, 7), 0, Location(17, 7)),
      Squad(10, 4, Location(17, 5), 0, Location(17, 5))
    )

  }
  var destinations = List.empty[Location]
  var terrain = List(
    Room(Location(2, 2), 16, 16),
    Room(Location(18, 3), 2, 1),
    Room(Location(20, 2), 16, 16)
  )
  var goToLocs = List.empty[Location]
  var projectileList = List.empty[Projectile]

  var selectedUnits = Squadgroup(List.empty, List.empty, Location(5, 5))
  var unselectedUnits = Squadgroup(List.empty, List.empty, Location(5, 5))
  var walls = List(Wall(Location(8, 8), 2, 2))
  def findSquad(location: Location): Squad = { // nulls
    squadList.find(thing => thing.location == location).orNull
  }

  var navigableLocations = List.empty[Location]

}
