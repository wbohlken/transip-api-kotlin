package nl.wouterbohlken.transip.entity.vps

import nl.wouterbohlken.transip.entity.Entity

class Upgrade(
  val name: String,
  val description: String,
  val price: Int,
  val recurringPrice: Int
): Entity() {
  override fun getIdentifier(): String = name
}