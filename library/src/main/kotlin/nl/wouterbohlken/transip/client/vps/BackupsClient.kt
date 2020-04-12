package nl.wouterbohlken.transip.client.vps

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.vps.Backup
import nl.wouterbohlken.transip.entity.vps.addons.Addon
import nl.wouterbohlken.transip.request.entity.vps.backup.Action
import java.lang.reflect.Type

class BackupsClient(token: String, var vpsName: String) : Client<Backup>(token) {

  override fun getEndpoint(): String = "vps/$vpsName/backups"

  override fun getItemType(): Type = Backup::class.java

  override fun getItemTypeArray(): Type = Array<Backup>::class.java

  override fun getIdentifierNameSingular(): String = "backup"

  override fun getIdentifierNamePlural(): String = "backups"

  fun revert(backup: Backup) = patch(backup.getIdentifier(), Action.revert())

  fun convertToSnapshot(backup: Backup, description: String? = null) =
    patch(backup.getIdentifier(), Action.convertToSnapshot(description))
}