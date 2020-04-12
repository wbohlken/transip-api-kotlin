package nl.wouterbohlken.transip.client.haip

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.request.entity.haip.SetAttachedIpAddresses
import java.lang.reflect.Type

class IpAddressesClient(token: String, var haipName: String) : Client<String>(token) {

  override fun getEndpoint(): String = "haips/$haipName/ip-addresses"

  override fun getItemType(): Type = String::class.java

  override fun getItemTypeArray(): Type = Array<String>::class.java

  override fun getIdentifierNameSingular(): String = "ipAddress"

  override fun getIdentifierNamePlural(): String = "ipAddresses"

  fun setAttachedIps(ipAddresses: List<String>) = put(SetAttachedIpAddresses(ipAddresses), "")

  fun detachAll() = delete("")

  /**
   * TODO: create list of all vps ip's
   */
//  fun attachVpses(vpses: List<Vps>) = setAttachedIps()
}