package nl.wouterbohlken.transip.entity.haip

import nl.wouterbohlken.transip.entity.Entity

class PortConfiguration(
  val id: Int,
  var name: String,
  var sourcePort: Int,
  var targetPort: Int,
  var mode: String,
  var endpointSslMode: String
): Entity() {
  override fun getIdentifier(): String = id.toString()
}