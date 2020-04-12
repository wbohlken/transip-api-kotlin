package nl.wouterbohlken.transip.client.colocation

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.colocation.IpAddress
import nl.wouterbohlken.transip.request.entity.colocation.CreateIpAddress
import java.lang.reflect.Type

class IpAddressesClient(token: String, var colocationName: String) : Client<IpAddress>(token) {

  override fun getEndpoint(): String = "colocations/$colocationName/ip-addresses"

  override fun getItemType(): Type = IpAddress::class.java

  override fun getItemTypeArray(): Type = Array<IpAddress>::class.java

  override fun getIdentifierNameSingular(): String = "ipAddress"

  override fun getIdentifierNamePlural(): String = "ipAddresses"

  fun create(createIpAddress: CreateIpAddress) = post(createIpAddress)

  fun setReverseDns(ipAddress: IpAddress) = put(ipAddress)

  fun deleteIpAddress(ipAddressAddress: String) = delete(ipAddressAddress)

  fun deleteIpAddress(ipAddress: IpAddress) = deleteIpAddress(ipAddress.getIdentifier())
}