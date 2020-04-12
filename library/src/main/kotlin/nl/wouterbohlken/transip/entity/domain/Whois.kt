package nl.wouterbohlken.transip.entity.domain

import nl.wouterbohlken.transip.entity.Entity

class Whois(
  val whois: String
): Entity() {
  override fun getIdentifier(): String = ""
}