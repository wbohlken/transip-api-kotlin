package nl.wouterbohlken.transip.entity.vps.tcp_monitor

import nl.wouterbohlken.transip.entity.Entity

class TcpMonitor(
  var ipAddress: String,
  var label: String,
  var ports: List<Int>,
  var interval: Int,
  var allowedTimeouts: Int,
  var contacts: List<Contact>,
  var ignoreTimes: List<IgnoreTime>
): Entity() {
  override fun getIdentifier(): String = ipAddress
}