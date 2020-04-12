package nl.wouterbohlken.transip.entity.vps

import nl.wouterbohlken.transip.entity.Entity

class Traffic(
  val startDate: String,
  val endDate: String,
  val usedInBytes: Int,
  val usedTotalBytes: Int,
  val maxInBytes: Int
): Entity() {
  override fun getIdentifier(): String = startDate
}