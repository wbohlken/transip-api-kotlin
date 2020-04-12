package nl.wouterbohlken.transip.client.vps

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.vps.VncData
import java.lang.reflect.Type

class VncClient(token: String, var vpsName: String) : Client<VncData>(token) {

  override fun getEndpoint(): String = "vps/$vpsName/vnc-data"

  override fun getItemType(): Type = VncData::class.java

  override fun getItemTypeArray(): Type = Array<VncData>::class.java

  override fun getIdentifierNameSingular(): String = "vncData"

  override fun getIdentifierNamePlural(): String = "vncData"

  fun regenerate() = patch(vpsName, HashMap())
}