package nl.wouterbohlken.transip.request.entity.big_storage

import nl.wouterbohlken.transip.request.entity.RequestEntity

class Order(
  val size: Int,
  val offsiteBackups: Boolean? = true,
  val availabilityZone: String? = null,
  val vpsName: String? = null
) : RequestEntity()