package nl.wouterbohlken.transip.client.vps

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.vps.Traffic
import nl.wouterbohlken.transip.entity.vps.Vps
import java.lang.reflect.Type

class TrafficClient(token: String) : Client<Traffic>(token) {

  override fun getEndpoint(): String = "traffic"

  override fun getItemType(): Type = Traffic::class.java

  override fun getItemTypeArray(): Type = Traffic::class.java

  override fun getIdentifierNameSingular(): String = "trafficInformation"

  override fun getIdentifierNamePlural(): String = "trafficInformation"

  fun getForVps(vpsName: String) = get(vpsName)

  fun getForVps(vps: Vps) = getForVps(vps.name)
}