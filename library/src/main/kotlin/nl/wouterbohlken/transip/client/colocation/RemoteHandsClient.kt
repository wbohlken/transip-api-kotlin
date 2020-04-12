package nl.wouterbohlken.transip.client.colocation

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.colocation.IpAddress
import nl.wouterbohlken.transip.entity.colocation.RemoteHands
import java.lang.reflect.Type

class RemoteHandsClient(token: String, var colocationName: String) : Client<RemoteHands>(token) {

  override fun getEndpoint(): String = "colocations/$colocationName/remote-hands"

  override fun getItemType(): Type = RemoteHands::class.java

  override fun getItemTypeArray(): Type = Array<RemoteHands>::class.java

  override fun getIdentifierNameSingular(): String = ""

  override fun getIdentifierNamePlural(): String = ""

  fun create(remoteHands: RemoteHands) = post(remoteHands)
}