package nl.wouterbohlken.transip.client.vps

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.vps.firewall.Firewall
import java.lang.reflect.Type

class FirewallClient(token: String, var vpsName: String) : Client<Firewall>(token) {

  override fun getEndpoint(): String = "vps/$vpsName/firewall"

  override fun getItemType(): Type = Firewall::class.java

  override fun getItemTypeArray(): Type = Array<Firewall>::class.java

  override fun getIdentifierNameSingular(): String = "vpsFirewall"

  override fun getIdentifierNamePlural(): String = "vpsFirewall"

  fun update(firewall: Firewall) = put(firewall)
}