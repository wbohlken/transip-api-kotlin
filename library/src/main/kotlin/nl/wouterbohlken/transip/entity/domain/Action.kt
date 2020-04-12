package nl.wouterbohlken.transip.entity.domain

import nl.wouterbohlken.transip.entity.Entity

class Action(
  val name: String,
  val message: String,
  val hasFailed: Boolean
): Entity() {
  override fun getIdentifier(): String = ""
}