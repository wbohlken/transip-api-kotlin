package nl.wouterbohlken.transip.entity.colocation

import nl.wouterbohlken.transip.entity.Entity

class Colocation(
  val name: String,
  val ipRanges: List<String>
): Entity() {
  override fun getIdentifier(): String = name
}