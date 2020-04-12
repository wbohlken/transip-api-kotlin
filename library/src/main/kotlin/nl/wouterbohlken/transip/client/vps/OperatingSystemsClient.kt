package nl.wouterbohlken.transip.client.vps

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.vps.OperatingSystem
import nl.wouterbohlken.transip.request.entity.vps.InstallOperatingSystem
import java.lang.reflect.Type

class OperatingSystemsClient(token: String, var vpsName: String) : Client<OperatingSystem>(token) {

  override fun getEndpoint(): String = "vps/$vpsName/operating-systems"

  override fun getItemType(): Type = OperatingSystem::class.java

  override fun getItemTypeArray(): Type = Array<OperatingSystem>::class.java

  override fun getIdentifierNameSingular(): String = "operatingSystem"

  override fun getIdentifierNamePlural(): String = "operatingSystems"

  fun install(operatingSystemName: String) = post(InstallOperatingSystem(operatingSystemName))
}