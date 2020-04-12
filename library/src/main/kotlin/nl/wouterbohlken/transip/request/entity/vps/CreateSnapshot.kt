package nl.wouterbohlken.transip.request.entity.vps

import nl.wouterbohlken.transip.request.entity.RequestEntity

class CreateSnapshot(
  val description: String,
  val shouldStartVps: Boolean? = true
) : RequestEntity()