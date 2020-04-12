package nl.wouterbohlken.transip.api

import nl.wouterbohlken.transip.client.haip.*

class Haip(val token: String) {
  private var haipClient = HaipClient(token)
  private lateinit var certificatesClient: CertificatesClient
  private lateinit var ipAddressesClient: IpAddressesClient
  private lateinit var portConfigurationsClient: PortConfigurationsClient
  private lateinit var statusReportsClient: StatusReportsClient

  fun haips(): HaipClient {
    return haipClient
  }

  fun certificates(haipName: String): CertificatesClient {
    if (!::certificatesClient.isInitialized) {
      certificatesClient = CertificatesClient(token, haipName)
    } else {
      certificatesClient.haipName = haipName
    }
    return certificatesClient
  }

  fun ipAddresses(haipName: String): IpAddressesClient {
    if (!::ipAddressesClient.isInitialized) {
      ipAddressesClient = IpAddressesClient(token, haipName)
    } else {
      ipAddressesClient.haipName = haipName
    }
    return ipAddressesClient
  }

  fun portConfigurations(haipName: String): PortConfigurationsClient {
    if (!::portConfigurationsClient.isInitialized) {
      portConfigurationsClient = PortConfigurationsClient(token, haipName)
    } else {
      portConfigurationsClient.haipName = haipName
    }
    return portConfigurationsClient
  }

  fun statusReports(haipName: String): StatusReportsClient {
    if (!::statusReportsClient.isInitialized) {
      statusReportsClient = StatusReportsClient(token, haipName)
    } else {
      statusReportsClient.haipName = haipName
    }
    return statusReportsClient
  }
}