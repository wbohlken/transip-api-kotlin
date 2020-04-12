package nl.wouterbohlken.transip.request.entity.vps

import nl.wouterbohlken.transip.request.entity.RequestEntity

class OrderMultiple(
  val vpsses: List<Order>
): RequestEntity()