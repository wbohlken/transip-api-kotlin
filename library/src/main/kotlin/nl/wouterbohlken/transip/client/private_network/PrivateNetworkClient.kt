package nl.wouterbohlken.transip.client.private_network

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.PrivateNetwork
import nl.wouterbohlken.transip.entity.vps.Vps
import nl.wouterbohlken.transip.request.entity.private_network.Action
import nl.wouterbohlken.transip.request.entity.EndTime
import nl.wouterbohlken.transip.request.entity.private_network.Order
import java.lang.reflect.Type

class PrivateNetworkClient(token: String) : Client<PrivateNetwork>(token) {

  override fun getEndpoint(): String = "private-networks"

  override fun getItemType(): Type = PrivateNetwork::class.java

  override fun getItemTypeArray(): Type = Array<PrivateNetwork>::class.java

  override fun getIdentifierNameSingular(): String = "privateNetwork"

  override fun getIdentifierNamePlural(): String = "privateNetworks"

  fun order(description: String?) = post(Order(description))

  fun update(privateNetwork: PrivateNetwork) = put(privateNetwork)

  fun attachVps(privateNetwork: PrivateNetwork, vpsName: String) = patch(privateNetwork, Action.attachVps(vpsName))

  fun attachVps(privateNetwork: PrivateNetwork, vps: Vps) = attachVps(privateNetwork, vps.name)

  fun detachVps(privateNetwork: PrivateNetwork, vpsName: String) = patch(privateNetwork, Action.detachVps(vpsName))

  fun detachVps(privateNetwork: PrivateNetwork, vps: Vps) = attachVps(privateNetwork, vps.name)

  fun cancel(privateNetwork: PrivateNetwork) = delete(privateNetwork)

  fun cancel(privateNetwork: PrivateNetwork, endTime: EndTime) =
    delete(privateNetwork, endTime)
}