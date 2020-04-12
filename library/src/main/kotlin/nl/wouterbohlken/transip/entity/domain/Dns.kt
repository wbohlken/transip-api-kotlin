package nl.wouterbohlken.transip.entity.domain

import nl.wouterbohlken.transip.entity.Entity

class Dns(
  val name: String,
  val expire: Int,
  val type: String,
  val content: String
): Entity() {
  override fun getIdentifier(): String = ""
}