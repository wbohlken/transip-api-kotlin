package nl.wouterbohlken.transip.entity.domain

import nl.wouterbohlken.transip.entity.Entity

class Availability(
  val domainName: String,
  val status: String,
  val actions: List<String>
): Entity() {
  override fun getIdentifier(): String = ""
}