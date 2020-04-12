package nl.wouterbohlken.transip.entity.vps

import nl.wouterbohlken.transip.entity.Entity

class Vps(
  val name: String,
  var description: String,
  val productName: String,
  val operatingSystem: String,
  val diskSize: Int,
  val memorySize: Int,
  val cpus: Int,
  val status: String,
  val ipAddress: String,
  val macAddress: String,
  val currentSnapshots: Int,
  val maxSnapshots: Int,
  val isLocked: Boolean,
  val isBlocked: Boolean,
  var isCustomerLocked: Boolean,
  val availabilityZone: String,
  val tags: List<String>
) : Entity() {
  override fun getIdentifier(): String = name
}