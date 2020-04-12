package nl.wouterbohlken.transip.client.haip

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.haip.Haip
import nl.wouterbohlken.transip.request.entity.haip.Order
import java.lang.reflect.Type

class HaipClient(token: String) : Client<Haip>(token) {

  override fun getEndpoint(): String = "haips"

  override fun getItemType(): Type = Haip::class.java

  override fun getItemTypeArray(): Type = Array<Haip>::class.java

  override fun getIdentifierNameSingular(): String = "haip"

  override fun getIdentifierNamePlural(): String = "haips"

  fun order(order: Order) = post(order)

  fun update(haip: Haip) = put(haip)

  fun cancel(haipName: String) = delete(haipName)

  fun cancel(haip: Haip) = cancel(haip.getIdentifier())
}