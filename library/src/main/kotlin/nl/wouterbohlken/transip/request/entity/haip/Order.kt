package nl.wouterbohlken.transip.request.entity.haip

import nl.wouterbohlken.transip.request.entity.RequestEntity

class Order(
  val productName: String,
  val description: String? = null
) : RequestEntity()