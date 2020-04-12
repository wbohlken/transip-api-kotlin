package nl.wouterbohlken.transip.client.vps

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.vps.addons.Addon
import nl.wouterbohlken.transip.entity.vps.addons.Addons
import nl.wouterbohlken.transip.request.entity.vps.OrderAddons
import java.lang.reflect.Type

class AddonsClient(token: String, var vpsName: String) : Client<Addons>(token) {

  override fun getEndpoint(): String = "vps/$vpsName/addons"

  override fun getItemType(): Type = Addons::class.java

  override fun getItemTypeArray(): Type = Addons::class.java

  override fun getIdentifierNameSingular(): String = "addons"

  override fun getIdentifierNamePlural(): String = "addons"

  fun order(addons: List<String>) = post(OrderAddons(addons))

  fun cancel(addonName: String) = delete(addonName)
}