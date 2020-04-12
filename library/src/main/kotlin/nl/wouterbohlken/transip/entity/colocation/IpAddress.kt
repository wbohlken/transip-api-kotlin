package nl.wouterbohlken.transip.entity.colocation

import nl.wouterbohlken.transip.entity.Entity

class IpAddress(
  val address: String,
  val subnetMask: String,
  val gateway: String,
  val dnsResolvers: List<String>,
  var reverseDns: String
): Entity() {
  override fun getIdentifier(): String = address
}