package nl.wouterbohlken.transip.client.vps

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.vps.Vps
import nl.wouterbohlken.transip.request.entity.vps.*
import java.lang.reflect.Type

class VpsClient(token: String) : Client<Vps>(token) {

  override fun getEndpoint(): String = "vps"

  override fun getItemType(): Type = Vps::class.java

  override fun getItemTypeArray(): Type = Array<Vps>::class.java

  override fun getIdentifierNameSingular(): String = "vps"

  override fun getIdentifierNamePlural(): String = "vpss"

  fun update(currentName: String, vps: Vps) = put(Update(currentName, vps))

  fun start(vpsName: String) = patch(vpsName, Action.start())

  fun start(vps: Vps) = start(vps.name)

  fun stop(vpsName: String) = patch(vpsName, Action.stop())

  fun stop(vps: Vps) = stop(vps.name)

  fun reset(vpsName: String) = patch(vpsName, Action.reset())

  fun reset(vps: Vps) = reset(vps.name)

  fun handover(vpsName: String, targetCustomerName: String) = patch(vpsName, Action.handover(targetCustomerName))

  fun handover(vps: Vps, targetCustomerName: String) = handover(vps.name, targetCustomerName)

  fun order(order: Order) = post(order)

  fun clone(clone: Clone) = post(clone)

  fun orderMultiple(orders: List<Order>) = post(OrderMultiple(orders))

  fun cancel(vps: Vps, endTime: String) = cancel(vps.name, endTime)

  fun cancel(vpsName: String, endTime: String) {
    val body = HashMap<String, String>()
    body["endTime"] = endTime
    delete(vpsName, body)
  }
}