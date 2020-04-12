package nl.wouterbohlken.transip.request.entity.haip

import nl.wouterbohlken.transip.request.entity.RequestEntity

class CreatePortConfiguration(
  val name: String,
  val sourcePort: Int,
  val targetPort: Int,
  val mode: String,
  val endpointSslMode: String
) : RequestEntity()