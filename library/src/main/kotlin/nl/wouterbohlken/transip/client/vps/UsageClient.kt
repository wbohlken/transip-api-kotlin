package nl.wouterbohlken.transip.client.vps

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.vps.usage.Usage
import java.lang.reflect.Type

class UsageClient(token: String, var vpsName: String) : Client<Usage>(token) {

  override fun getEndpoint(): String = "vps/$vpsName/usage"

  override fun getItemType(): Type = Usage::class.java

  override fun getItemTypeArray(): Type = Array<Usage>::class.java

  override fun getIdentifierNameSingular(): String = "usage"

  override fun getIdentifierNamePlural(): String = "usage"
}