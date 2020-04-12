package nl.wouterbohlken.transip.entity.general

import nl.wouterbohlken.transip.entity.Entity

class Product (
  val name: String,
  val description: String,
  val price: Int,
  val recurringPrice: Int
): Entity() {
  override fun getIdentifier(): String = name
}