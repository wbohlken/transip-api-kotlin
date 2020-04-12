package nl.wouterbohlken.transip.client.vps

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.vps.Upgrade
import nl.wouterbohlken.transip.entity.vps.addons.Addon
import nl.wouterbohlken.transip.request.entity.vps.OrderUpgrade
import java.lang.reflect.Type

class UpgradesClient(token: String, var vpsName: String) : Client<Upgrade>(token) {

  override fun getEndpoint(): String = "vps/$vpsName/upgrades"

  override fun getItemType(): Type = Upgrade::class.java

  override fun getItemTypeArray(): Type = Array<Upgrade>::class.java

  override fun getIdentifierNameSingular(): String = "upgrade"

  override fun getIdentifierNamePlural(): String = "upgrades"

  fun order(upgradeName: String) = post(OrderUpgrade(upgradeName))
}