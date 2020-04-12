package nl.wouterbohlken.transip.examples

import nl.wouterbohlken.transip.VpsEndTime
import nl.wouterbohlken.transip.api.TransipAPI
import nl.wouterbohlken.transip.entity.MonitoringContact
import nl.wouterbohlken.transip.request.entity.vps.Clone
import nl.wouterbohlken.transip.request.entity.vps.Order

class VpsExamples {
  val api = TransipAPI(TransipAPI.demoToken)

  fun doStuff() {
    getVpses()
    getVps()
    order()
    orderMultiple()
    clone()
    update()
    start()
    stop()
    reset()
    handover()
    cancel()

    getUsage()

    getVncData()
    regenerateVncData()

    orderAddons()
    cancelAddon()

    orderUpgrade()

    installOperatingSystem()

    getIpAddresses()
    updateReverseDns()
    removeIpAddress()

    getSnapshots()
    createSnapshot()
    revertSnapshot()
    deleteSnapshot()

    getBackups()
    revertBackup()
    convertBackupToSnapshot()

    updateReverseIpAddress()

    listFirewall()
    updateFirewall()

    getTrafficPool()
    getTraffic()

    getMailServiceInformation()
    regenerateMailServicePassword()
    addMailServiceDnsEntriesToDomains()

    listTcpMonitors()
    createTcpMonitor()
    updateTcpMonitor()
    deleteTcpMonitor()

    listMonitoringContacts()
    createMonitoringContact()
    updateMonitoringContact()
    deleteMonitoringContact()
  }

  fun getVpses() {
    val vpses = api.vps.vpses().list()
    println(vpses[0].name)
  }

  fun getVps() {
    val vpses = api.vps.vpses().list()
    val vps = api.vps.vpses().get(vpses[0].name)
    println(vps.name)
  }

  fun clone() {
    val vps = api.vps.vpses().list()[0]
    api.vps.vpses().clone(Clone(vps.name, "ams0"))
  }

  fun getBackups() {
    val vpsName = api.vps.vpses().list()[0].name
    val backups = api.vps.backups(vpsName).list()
    println(backups[0].dateTimeCreate + " " + backups[0].diskSize)
  }

  fun convertBackupToSnapshot() {
    val vpsName = api.vps.vpses().list()[0].name
    val backup = api.vps.backups(vpsName).list()[0]
    api.vps.backups(vpsName).convertToSnapshot(backup, "BeforeItsAllBroken")
  }

  fun revertBackup() {
    val vpsName = api.vps.vpses().list()[0].name
    val backup = api.vps.backups(vpsName).list()[0]
    api.vps.backups(vpsName).revert(backup)
  }

  fun getSnapshots() {
    val vpsIdentifier = api.vps.vpses().list()[0].getIdentifier()
    val snapshots = api.vps.snapshots(vpsIdentifier).list()
    println(snapshots[0].name + " " + snapshots[0].diskSize)
  }

  fun createSnapshot() {
    val vpsName = api.vps.vpses().list()[0].name
    api.vps.snapshots(vpsName).create("BeforeItsAllBroken")
  }

  fun revertSnapshot() {
    val vpsName = api.vps.vpses().list()[0].name
    val snapshot = api.vps.snapshots(vpsName).list()[0]
    api.vps.snapshots(vpsName).revert(snapshot)
  }

  fun deleteSnapshot() {
    val vpsName = api.vps.vpses().list()[0].name
    val snapshot = api.vps.snapshots(vpsName).list()[0]
    api.vps.snapshots(vpsName).deleteSnapshot(snapshot)
  }

  fun updateReverseIpAddress() {
    val vpsName = api.vps.vpses().list()[0].name
    val ipAddress = api.vps.ipAddresses(vpsName).list()[0]
    ipAddress.reverseDns = "example.com"
    api.vps.ipAddresses(vpsName).updateReverseDns(ipAddress)
  }

  fun installOperatingSystem() {
    val vps = api.vps.vpses().list()[0]
    val operatingSystems = api.vps.operatingSystems(vps.name).list()
    api.vps.operatingSystems(vps.name).install(operatingSystems[0].name)
  }

  fun orderAddons() {
    val vps = api.vps.vpses().list()[0]
    val addons = api.vps.addons(vps.name).get()
    api.vps.addons(vps.name).order(listOf(addons.available[0].name, addons.available[1].name))
  }

  fun cancelAddon() {
    val vps = api.vps.vpses().list()[0]
    val addons = api.vps.addons(vps.name).get()
    api.vps.addons(vps.name).cancel(addons.active[0].name)
  }

  fun orderUpgrade() {
    val vps = api.vps.vpses().list()[0]
    val upgrades = api.vps.upgrades(vps.name).list()
    api.vps.upgrades(vps.name).order(upgrades[0].name)
  }

  fun handover() {
    val vps = api.vps.vpses().list()[0]
    api.vps.vpses().handover(vps, "wbohlken")
  }

  fun getUsage() {
    val vps = api.vps.vpses().list()[0]
    val usage = api.vps.usage(vps.name).get()
    println(usage.cpu[0].percentage)
  }

  fun getIpAddresses() {
    val vpsName = api.vps.vpses().list()[0].name

    val ipAddressList = api.vps.ipAddresses(vpsName).list()
    println(ipAddressList[0].address)
//    println(ipAddressList._links[0])
  }

  fun updateReverseDns() {
    val vpsName = api.vps.vpses().list()[0].name

    val ipAddress = api.vps.ipAddresses(vpsName).list()[0]
    ipAddress.reverseDns = "example.com"
    api.vps.ipAddresses(vpsName).updateReverseDns(ipAddress)
  }

  fun removeIpAddress() {
    val vpsName = api.vps.vpses().list()[0].name
    val ipAddress = api.vps.ipAddresses(vpsName).list()[0]
    api.vps.ipAddresses(vpsName).removeFromVps(ipAddress)
  }

  /**
   * TODO: Response type for this call is JsonArray, catch it and find a solution
   */
  fun order() {
    val vpsOrder = Order(
      "vps-bladevps-x8",
      "ubuntu-18.04",
      hostname = "test"
    )

    api.vps.vpses().order(vpsOrder)
  }

  /**
   * TODO: Response type for this call is JsonArray, catch it and find a solution
   */
  fun orderMultiple() {
    val vpsOrder1 = Order(
      "vps-bladevps-x8",
      "ubuntu-18.04",
      hostname = "test"
    )
    val vpsOrder2 = Order(
      "vps-bladevps-x4",
      "ubuntu-16.04",
      hostname = "test"
    )

    val vpsOrders = ArrayList<Order>()
    vpsOrders.add(vpsOrder1)
    vpsOrders.add(vpsOrder2)

    api.vps.vpses().orderMultiple(vpsOrders)
  }

  fun update() {
    val vps = api.vps.vpses().list()[0]
    val currentName = vps.name
    vps.description = "test"
    api.vps.vpses().update(currentName, vps)
  }

  fun start() {
    val vps = api.vps.vpses().list()[0]
    api.vps.vpses().start(vps)
  }

  fun stop() {
    val vps = api.vps.vpses().list()[0]
    api.vps.vpses().stop(vps)
  }

  fun reset() {
    val vps = api.vps.vpses().list()[0]
    api.vps.vpses().reset(vps)
  }

  fun cancel() {
    val vps = api.vps.vpses().list()[0]
    api.vps.vpses().cancel(vps, VpsEndTime.END)
  }

  fun getVncData() {
    val vps = api.vps.vpses().list()[0]
    val vncData = api.vps.vncData(vps.name).get()
    println(vncData.host)
  }

  fun regenerateVncData() {
    val vps = api.vps.vpses().list()[0]
    api.vps.vncData(vps.name).regenerate()
  }


  fun listFirewall() {
    val vps = api.vps.vpses().list()[0]
    val firewall = api.vps.firewall(vps.name).get()
    println(firewall.ruleSet[0].description)
  }

  fun updateFirewall() {
    val vps = api.vps.vpses().list()[0]
    val firewall = api.vps.firewall(vps.name).get()
    firewall.ruleSet[0].protocol = "tcp"
    api.vps.firewall(vps.name).update(firewall)
  }

  /**
   * TODO: incorrect URL, should be /traffic and /traffic/{vpsName}
   */
  fun getTrafficPool() {
    val traffic = api.vps.traffic().get()
    println(traffic.usedInBytes)
  }

  fun getTraffic() {
    val vps = api.vps.vpses().list()[0]
    val traffic = api.vps.traffic().getForVps(vps)
    println(traffic.usedInBytes)
  }

  fun getMailServiceInformation() {
    val mailService = api.mailService.mailService().get()
    println(mailService.dnsTxt)
  }

  fun regenerateMailServicePassword() {
    api.mailService.mailService().regenerate()
  }

  fun addMailServiceDnsEntriesToDomains() {
    val domain = api.domain.domains().list()[0]
    api.mailService.mailService().addDnsEntriesToDomain(domain)
  }

  fun listTcpMonitors() {
    val vps = api.vps.vpses().list()[0]
    val tcpMonitors = api.vps.tcpMonitors(vps.name).list()
    println(tcpMonitors[0].label)
  }

  fun createTcpMonitor() {
    val vps = api.vps.vpses().list()[0]
    val tcpMonitor = api.vps.tcpMonitors(vps.name).list()[0]
    tcpMonitor.label = "test"
    api.vps.tcpMonitors(vps.name).create(tcpMonitor)
  }

  fun updateTcpMonitor() {
    val vps = api.vps.vpses().list()[0]
    val tcpMonitor = api.vps.tcpMonitors(vps.name).list()[0]
    tcpMonitor.label = "test"
    api.vps.tcpMonitors(vps.name).update(tcpMonitor)
  }

  fun deleteTcpMonitor() {
    val vps = api.vps.vpses().list()[0]
    val tcpMonitor = api.vps.tcpMonitors(vps.name).list()[0]
    api.vps.tcpMonitors(vps.name).deleteTcpMonitor(tcpMonitor)
  }

  fun listMonitoringContacts() {
    val monitoringContacts = api.monitoringContact.monitoringContacts().list()
    println(monitoringContacts[0].email)
  }

  fun createMonitoringContact() {
    api.monitoringContact.monitoringContacts()
      .create(MonitoringContact("John Wick", "+31612345678", "j.wick@example.com"))
  }

  fun updateMonitoringContact() {
    val monitoringContact = api.monitoringContact.monitoringContacts().list()[0]
    monitoringContact.email = "test"
    api.monitoringContact.monitoringContacts().update(monitoringContact)
  }

  fun deleteMonitoringContact() {
    val monitoringContact = api.monitoringContact.monitoringContacts().list()[0]
    api.monitoringContact.monitoringContacts().deleteMonitoringContact(monitoringContact)
  }
}