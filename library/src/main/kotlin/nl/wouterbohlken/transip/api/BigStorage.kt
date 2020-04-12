package nl.wouterbohlken.transip.api

import nl.wouterbohlken.transip.client.big_storage.BackupsClient
import nl.wouterbohlken.transip.client.big_storage.BigStoragesClient
import nl.wouterbohlken.transip.client.big_storage.UsageClient

class BigStorage(val token: String) {
  private var bigStoragesClient = BigStoragesClient(token)
  private lateinit var backupsClient: BackupsClient
  private lateinit var usageClient: UsageClient

  fun bigStorages(): BigStoragesClient {
    return bigStoragesClient
  }

  fun backups(bigStorageName: String): BackupsClient {
    if (!::backupsClient.isInitialized) {
      backupsClient = BackupsClient(token, bigStorageName)
    } else {
      backupsClient.bigStorageName = bigStorageName
    }
    return backupsClient
  }

  fun usage(bigStorageName: String): UsageClient {
    if (!::usageClient.isInitialized) {
      usageClient = UsageClient(token, bigStorageName)
    } else {
      usageClient.bigStorageName = bigStorageName
    }
    return usageClient
  }
}