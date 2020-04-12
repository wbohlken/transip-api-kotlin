package nl.wouterbohlken.transip.entity.big_storage

import nl.wouterbohlken.transip.entity.Entity

class Usage(
  val iopsRead: Float,
  val iopsWrite: Float,
  val date: Int
): Entity() {
  override fun getIdentifier(): String = ""
}