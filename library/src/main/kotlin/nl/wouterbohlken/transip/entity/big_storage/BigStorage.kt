package nl.wouterbohlken.transip.entity.big_storage

import nl.wouterbohlken.transip.entity.Entity
import nl.wouterbohlken.transip.entity.vps.Vps

class BigStorage(
  val name: String,
  var description: String,
  val diskSize: Int,
  val offsiteBackups: Boolean,
  var vpsName: String?,
  val status: String,
  val isLocked: Boolean,
  val availabilityZone: String
) : Entity() {
  override fun getIdentifier(): String = name

  fun detachVps() {
    vpsName = null
  }

  fun attachVps(vpsName: String) {
    this.vpsName = vpsName
  }

  fun attachVps(vps: Vps) = attachVps(vps.name)
}