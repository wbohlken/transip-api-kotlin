package nl.wouterbohlken.transip.client.vps

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.vps.IpAddress
import nl.wouterbohlken.transip.request.entity.vps.ip_address.UpdateReverseDns
import java.lang.reflect.Type

class IpAddressClient(token: String, var vpsName: String) : Client<IpAddress>(token) {

  override fun getEndpoint(): String = "vps/$vpsName/ip-addresses"

  override fun getItemType(): Type = IpAddress::class.java

  override fun getItemTypeArray(): Type = Array<IpAddress>::class.java

  override fun getIdentifierNameSingular(): String = "ipAddress"

  override fun getIdentifierNamePlural(): String = "ipAddresses"

  fun updateReverseDns(ipAddress: IpAddress) = put(UpdateReverseDns(ipAddress), ipAddress.getIdentifier())

  fun removeFromVps(ipAddressAddress: String) = delete(ipAddressAddress)

  fun removeFromVps(ipAddress: IpAddress) = removeFromVps(ipAddress.getIdentifier())
}