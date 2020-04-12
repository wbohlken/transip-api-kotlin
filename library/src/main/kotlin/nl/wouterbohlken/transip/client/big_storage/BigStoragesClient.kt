package nl.wouterbohlken.transip.client.big_storage

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.big_storage.BigStorage
import nl.wouterbohlken.transip.request.entity.big_storage.Order
import nl.wouterbohlken.transip.request.entity.big_storage.Upgrade
import nl.wouterbohlken.transip.request.entity.EndTime
import java.lang.reflect.Type

class BigStoragesClient(token: String) : Client<BigStorage>(token) {

  override fun getEndpoint(): String = "big-storages"

  override fun getItemType(): Type = BigStorage::class.java

  override fun getItemTypeArray(): Type = Array<BigStorage>::class.java

  override fun getIdentifierNameSingular(): String = "bigStorage"

  override fun getIdentifierNamePlural(): String = "bigStorages"

  fun order(order: Order) = post(order)

  fun upgrade(upgrade: Upgrade) = post(upgrade)

  fun update(bigStorage: BigStorage) = put(bigStorage)

  fun cancel(bigStorage: BigStorage) = delete(bigStorage)

  fun cancel(bigStorage: BigStorage, endTime: EndTime) = delete(bigStorage, endTime)
}