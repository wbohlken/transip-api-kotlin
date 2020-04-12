package nl.wouterbohlken.transip.entity.vps.addons

import nl.wouterbohlken.transip.entity.Entity

abstract class Addon(
  val name: String,
  val description: String,
  val price: Int,
  val recurringPrice: Int
): Entity() {
  override fun getIdentifier(): String = name
}