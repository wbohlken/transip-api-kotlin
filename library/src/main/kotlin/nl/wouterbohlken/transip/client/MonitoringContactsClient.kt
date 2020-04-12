package nl.wouterbohlken.transip.client

import nl.wouterbohlken.transip.entity.MonitoringContact
import java.lang.reflect.Type

class MonitoringContactsClient(token: String) : Client<MonitoringContact>(token) {

  override fun getEndpoint(): String = "monitoring-contacts"

  override fun getItemType(): Type = MonitoringContact::class.java

  override fun getItemTypeArray(): Type = Array<MonitoringContact>::class.java

  override fun getIdentifierNameSingular(): String = "contact"

  override fun getIdentifierNamePlural(): String = "contacts"

  fun create(monitoringContact: MonitoringContact) = post(monitoringContact)

  fun update(monitoringContact: MonitoringContact) = put(monitoringContact)

  fun deleteMonitoringContact(monitoringContact: MonitoringContact) = delete(monitoringContact)
}