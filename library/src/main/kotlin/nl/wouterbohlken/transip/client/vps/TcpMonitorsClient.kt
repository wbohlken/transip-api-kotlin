package nl.wouterbohlken.transip.client.vps

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.vps.tcp_monitor.TcpMonitor
import java.lang.reflect.Type

class TcpMonitorsClient(token: String, var vpsName: String) : Client<TcpMonitor>(token) {

  override fun getEndpoint(): String = "vps/$vpsName/tcp-monitors"

  override fun getItemType(): Type = TcpMonitor::class.java

  override fun getItemTypeArray(): Type = Array<TcpMonitor>::class.java

  override fun getIdentifierNameSingular(): String = "tcpMonitor"

  override fun getIdentifierNamePlural(): String = "tcpMonitors"

  fun create(tcpMonitor: TcpMonitor) = post(tcpMonitor)

  fun update(tcpMonitor: TcpMonitor) = put(tcpMonitor)

  fun deleteTcpMonitor(tcpMonitor: TcpMonitor) = delete(tcpMonitor)
}