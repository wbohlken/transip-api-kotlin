package nl.wouterbohlken.transip.request.entity.big_storage

import nl.wouterbohlken.transip.request.entity.RequestEntity

class Upgrade(
  val bigStorageName: String,
  val size: Int,
  val offsiteBackups: Boolean? = false
) : RequestEntity()