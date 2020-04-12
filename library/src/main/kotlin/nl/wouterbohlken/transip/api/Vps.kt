package nl.wouterbohlken.transip.api

import nl.wouterbohlken.transip.client.vps.*

class Vps(val token: String) {
  private var vpsClient = VpsClient(token)
  private var trafficClient = TrafficClient(token)
  private lateinit var usageClient: UsageClient
  private lateinit var vncClient: VncClient
  private lateinit var addonsClient: AddonsClient
  private lateinit var upgradesClient: UpgradesClient
  private lateinit var operatingSystemsClient: OperatingSystemsClient
  private lateinit var ipAddressClient: IpAddressClient
  private lateinit var snapshotsClient: SnapshotsClient
  private lateinit var backupsClient: BackupsClient
  private lateinit var firewallClient: FirewallClient
  private lateinit var tcpMonitorsClient: TcpMonitorsClient

  fun vpses(): VpsClient {
    return vpsClient
  }

  /**
   * TODO: Date start and end
   * validate that it works when only certain types of usage are given
   */
  fun usage(vpsName: String): UsageClient {
    if (!::usageClient.isInitialized) {
      usageClient = UsageClient(token, vpsName)
    } else {
      usageClient.vpsName = vpsName
    }
    return usageClient
  }

  fun vncData(vpsName: String): VncClient {
    if (!::vncClient.isInitialized) {
      vncClient = VncClient(token, vpsName)
    } else {
      vncClient.vpsName = vpsName
    }
    return vncClient
  }

  fun addons(vpsName: String): AddonsClient {
    if (!::addonsClient.isInitialized) {
      addonsClient = AddonsClient(token, vpsName)
    } else {
      addonsClient.vpsName = vpsName
    }
    return addonsClient
  }

  fun upgrades(vpsName: String): UpgradesClient {
    if (!::upgradesClient.isInitialized) {
      upgradesClient = UpgradesClient(token, vpsName)
    } else {
      upgradesClient.vpsName = vpsName
    }
    return upgradesClient
  }

  fun operatingSystems(vpsName: String): OperatingSystemsClient {
    if (!::operatingSystemsClient.isInitialized) {
      operatingSystemsClient = OperatingSystemsClient(token, vpsName)
    } else {
      operatingSystemsClient.vpsName = vpsName
    }
    return operatingSystemsClient
  }

  fun ipAddresses(vpsName: String): IpAddressClient {
    if (!::ipAddressClient.isInitialized) {
      ipAddressClient = IpAddressClient(token, vpsName)
    } else {
      ipAddressClient.vpsName = vpsName
    }
    return ipAddressClient
  }

  fun snapshots(vpsName: String): SnapshotsClient {
    if (!::snapshotsClient.isInitialized) {
      snapshotsClient = SnapshotsClient(token, vpsName)
    } else {
      snapshotsClient.vpsName = vpsName
    }
    return snapshotsClient
  }

  fun backups(vpsName: String): BackupsClient {
    if (!::backupsClient.isInitialized) {
      backupsClient = BackupsClient(token, vpsName)
    } else {
      backupsClient.vpsName = vpsName
    }
    return backupsClient
  }

  fun firewall(vpsName: String): FirewallClient {
    if (!::firewallClient.isInitialized) {
      firewallClient = FirewallClient(token, vpsName)
    } else {
      firewallClient.vpsName = vpsName
    }
    return firewallClient
  }

  fun traffic(): TrafficClient {
    return trafficClient
  }

  fun tcpMonitors(vpsName: String): TcpMonitorsClient {
    if (!::tcpMonitorsClient.isInitialized) {
      tcpMonitorsClient = TcpMonitorsClient(token, vpsName)
    } else {
      tcpMonitorsClient.vpsName = vpsName
    }
    return tcpMonitorsClient
  }
}