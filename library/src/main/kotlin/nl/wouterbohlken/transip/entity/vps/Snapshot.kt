package nl.wouterbohlken.transip.entity.vps

import nl.wouterbohlken.transip.entity.Entity

class Snapshot(
  val name: String,
  val description: String,
  val diskSize: Int,
  val status: String,
  val dateTimeCreate: String,
  val operatingSystem: String
): Entity() {
  override fun getIdentifier(): String = name
}