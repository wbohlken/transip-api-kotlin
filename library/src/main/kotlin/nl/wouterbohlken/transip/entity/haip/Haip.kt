package nl.wouterbohlken.transip.entity.haip

import nl.wouterbohlken.transip.entity.Entity

class Haip(
  val name: String,
  var description: String,
  val status: String,
  val isLoadBalancingEnabled: Boolean,
  val loadBalancingMode: String,
  val stickyCookieName: String,
  val healthCheckInterval: Int,
  var httpHealthCheckPath: String,
  var httpHealthCheckPort: Int,
  val httpHealthCheckSsl: Boolean,
  val ipv4Address: String,
  val ipv6Address: String,
  val ipSetup: String,
  var ptrRecord: String,
  val ipAddresses: List<String>
): Entity() {
  override fun getIdentifier(): String = name
}