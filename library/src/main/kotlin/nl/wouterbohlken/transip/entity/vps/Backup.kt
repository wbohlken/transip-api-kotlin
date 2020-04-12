package nl.wouterbohlken.transip.entity.vps

import nl.wouterbohlken.transip.entity.Entity

class Backup(
  val id: Int,
  val status: String,
  val dateTimeCreate: String,
  val diskSize: Int,
  val operatingSystem: String,
  val availabilityZone: String
): Entity() {
  override fun getIdentifier(): String = id.toString()
}