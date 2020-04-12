package nl.wouterbohlken.transip.entity.haip

import nl.wouterbohlken.transip.entity.Entity

class StatusReport(
  val ipAddress: String,
  val port: Int,
  val ipVersion: Int,
  val loadBalancerName: String,
  val loadBalancerIp: String,
  val state: String,
  val lastChange: String
): Entity() {
  override fun getIdentifier(): String = ""
}