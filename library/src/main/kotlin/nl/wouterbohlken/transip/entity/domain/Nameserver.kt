package nl.wouterbohlken.transip.entity.domain

import nl.wouterbohlken.transip.entity.Entity

class Nameserver(
  val hostname: String,
  val ipv4: String? = null,
  val ipv6: String? = null
): Entity() {
  override fun getIdentifier(): String = ""
}