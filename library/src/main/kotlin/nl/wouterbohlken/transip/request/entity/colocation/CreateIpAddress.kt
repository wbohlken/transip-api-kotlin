package nl.wouterbohlken.transip.request.entity.colocation

import nl.wouterbohlken.transip.request.entity.RequestEntity

class CreateIpAddress(
  val ipAddress: String,
  val reverseDns: String? = null
) : RequestEntity()