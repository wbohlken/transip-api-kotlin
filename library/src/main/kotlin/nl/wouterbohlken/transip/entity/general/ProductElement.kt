package nl.wouterbohlken.transip.entity.general

import nl.wouterbohlken.transip.Serializable

class ProductElement(
  val name: String,
  val description: String,
  val amount: Int
) : Serializable