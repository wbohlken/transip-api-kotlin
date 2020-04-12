package nl.wouterbohlken.transip.entity.haip

import nl.wouterbohlken.transip.entity.Entity

class Certificate(
  val id: Int,
  val commonName: String,
  val expirationDate: String
): Entity() {
  override fun getIdentifier(): String = id.toString()
}