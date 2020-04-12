package nl.wouterbohlken.transip.examples

import nl.wouterbohlken.transip.api.TransipAPI
import nl.wouterbohlken.transip.request.entity.big_storage.Order
import nl.wouterbohlken.transip.request.entity.big_storage.Upgrade

class BigStoragesExamples {
  val api = TransipAPI(TransipAPI.demoToken)

  fun doStuff() {
    listBigStorages()
    getBigStorage()
    orderBigStorage()
    upgradeBigStorage()
    updateBigStorage()
    cancelBigStorage()

    getBigStorageUsageStatistics()

    listBigStorageBackups()
    revertBigStorageBackup()
  }

  fun listBigStorages() {
    val bigStorages = api.bigStorage.bigStorages().list()
    println(bigStorages[0].name)
  }

  fun getBigStorage() {
    val bigStorageIdentifier = api.bigStorage.bigStorages().list()[0].getIdentifier()
    val bigStorage = api.bigStorage.bigStorages().get(bigStorageIdentifier)
    println(bigStorage.name)
  }

  fun orderBigStorage() {
    api.bigStorage.bigStorages().order(Order(2))
  }

  fun upgradeBigStorage() {
    val bigStorage = api.bigStorage.bigStorages().list()[0]
    api.bigStorage.bigStorages().upgrade(Upgrade(bigStorage.name, 4))
  }

  fun updateBigStorage() {
    val bigStorage = api.bigStorage.bigStorages().list()[0]
    bigStorage.detachVps()
    api.bigStorage.bigStorages().update(bigStorage)

    val vps = api.vps.vpses().list()[0]
    bigStorage.attachVps(vps)
    api.bigStorage.bigStorages().update(bigStorage)
  }

  fun cancelBigStorage() {
    val bigStorage = api.bigStorage.bigStorages().list()[0]
    api.bigStorage.bigStorages().cancel(bigStorage)
  }

  fun getBigStorageUsageStatistics() {
    val bigStorage = api.bigStorage.bigStorages().list()[0]
    val usage = api.bigStorage.usage(bigStorage.getIdentifier()).get()
    println(usage.date)
  }

  fun listBigStorageBackups() {
    val bigStorage = api.bigStorage.bigStorages().list()[0]
    val backups = api.bigStorage.backups(bigStorage.getIdentifier()).list()
    println(backups[0].diskSize)
  }

  fun revertBigStorageBackup() {
    val bigStorage = api.bigStorage.bigStorages().list()[0]
    val backup = api.bigStorage.backups(bigStorage.getIdentifier()).list()[0]
    api.bigStorage.backups(bigStorage.name).revert(backup)
  }
}