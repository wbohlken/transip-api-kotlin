package nl.wouterbohlken.transip.client.vps

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.vps.Snapshot
import nl.wouterbohlken.transip.request.entity.vps.CreateSnapshot
import nl.wouterbohlken.transip.request.entity.vps.RevertSnapshot
import java.lang.reflect.Type

class SnapshotsClient(token: String, var vpsName: String) : Client<Snapshot>(token) {

  override fun getEndpoint(): String = "vps/$vpsName/snapshots"

  override fun getItemType(): Type = Snapshot::class.java

  override fun getItemTypeArray(): Type = Array<Snapshot>::class.java

  override fun getIdentifierNameSingular(): String = "snapshot"

  override fun getIdentifierNamePlural(): String = "snapshots"

  fun create(description: String, shouldStartVps: Boolean? = true) = post(CreateSnapshot(description, shouldStartVps))

  fun revert(snapshot: Snapshot, destinationVpsName: String) = patch(snapshot, RevertSnapshot(destinationVpsName))

  fun revert(snapshot: Snapshot) = patch(snapshot, RevertSnapshot())

  fun deleteSnapshot(snapshot: Snapshot) = delete(snapshot)
}