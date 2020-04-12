package nl.wouterbohlken.transip.request.entity.vps

import nl.wouterbohlken.transip.request.entity.RequestEntity

class Usage(
  val types: String,
  val dateTimeStart: Int,
  val dateTimeEnd: Int
) : RequestEntity()