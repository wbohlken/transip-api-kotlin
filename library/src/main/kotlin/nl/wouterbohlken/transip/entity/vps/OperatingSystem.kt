package nl.wouterbohlken.transip.entity.vps

import nl.wouterbohlken.transip.entity.Entity

class OperatingSystem(
  val name: String,
  val description: String,
  val isPreinstallableImage: Boolean,
  val version: String,
  val price: Int
): Entity() {
  override fun getIdentifier(): String = name
}