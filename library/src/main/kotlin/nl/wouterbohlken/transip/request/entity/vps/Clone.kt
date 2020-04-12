package nl.wouterbohlken.transip.request.entity.vps

import nl.wouterbohlken.transip.request.entity.RequestEntity

class Clone(
  val vpsName: String,
  val availabilityZone: String
): RequestEntity()