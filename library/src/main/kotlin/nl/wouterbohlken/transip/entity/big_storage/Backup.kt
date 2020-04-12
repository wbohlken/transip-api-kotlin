package nl.wouterbohlken.transip.entity.big_storage

import nl.wouterbohlken.transip.entity.Entity

class Backup(
  val id: Int,
  val status: String,
  val diskSize: Int,
  val dateTimeCreate: String,
  val availabilityZone: String
): Entity() {
  override fun getIdentifier(): String = id.toString()
}