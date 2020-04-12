package nl.wouterbohlken.transip.api

import nl.wouterbohlken.transip.client.MonitoringContactsClient

class MonitoringContact(val token: String) {
  private var monitoringContactsClient = MonitoringContactsClient(token)

  fun monitoringContacts(): MonitoringContactsClient {
    return monitoringContactsClient
  }
}