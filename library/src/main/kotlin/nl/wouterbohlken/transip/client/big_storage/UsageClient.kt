package nl.wouterbohlken.transip.client.big_storage

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.big_storage.Usage
import java.lang.reflect.Type

/**
 * TODO: Get all method has request body with dateTimeStart and dateTimeEnd
 */
class UsageClient(token: String, var bigStorageName: String) : Client<Usage>(token) {

  override fun getEndpoint(): String = "big-storages/$bigStorageName/usage"

  override fun getItemType(): Type = Usage::class.java

  override fun getItemTypeArray(): Type = Array<Usage>::class.java

  override fun getIdentifierNameSingular(): String = "usage"

  override fun getIdentifierNamePlural(): String = "usage"
}