package nl.wouterbohlken.transip.client.big_storage

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.big_storage.Backup
import nl.wouterbohlken.transip.entity.big_storage.BigStorage
import nl.wouterbohlken.transip.request.entity.big_storage.backup.Action
import java.lang.reflect.Type

class BackupsClient(token: String, var bigStorageName: String) : Client<Backup>(token) {

  override fun getEndpoint(): String = "big-storages/$bigStorageName/backups"

  override fun getItemType(): Type = BigStorage::class.java

  override fun getItemTypeArray(): Type = Array<BigStorage>::class.java

  override fun getIdentifierNameSingular(): String = "bigStorage"

  override fun getIdentifierNamePlural(): String = "bigStorages"

  fun revert(backupId: String) = patch(backupId, Action.revert())

  fun revert(backup: Backup) = revert(backup.getIdentifier())
}