package nl.wouterbohlken.transip.entity.domain

import nl.wouterbohlken.transip.entity.Entity

class Dnssec(
  val keyTag: Int,
  val flags: Int,
  val algorithm: Int,
  val publicKey: String
): Entity() {
  override fun getIdentifier(): String = ""
}