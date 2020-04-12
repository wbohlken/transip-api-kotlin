package nl.wouterbohlken.transip.client.haip

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.haip.PortConfiguration
import nl.wouterbohlken.transip.request.entity.haip.CreatePortConfiguration
import java.lang.reflect.Type

class PortConfigurationsClient(token: String, var haipName: String) : Client<PortConfiguration>(token) {

  override fun getEndpoint(): String = "haips/$haipName/port-configurations"

  override fun getItemType(): Type = PortConfiguration::class.java

  override fun getItemTypeArray(): Type = Array<PortConfiguration>::class.java

  override fun getIdentifierNameSingular(): String = "portConfiguration"

  override fun getIdentifierNamePlural(): String = "portConfigurations"

  fun create(portConfiguration: CreatePortConfiguration) = post(portConfiguration)

  fun update(portConfiguration: PortConfiguration) = post(portConfiguration)

  fun remove(portConfiguration: PortConfiguration) = delete(portConfiguration)
}