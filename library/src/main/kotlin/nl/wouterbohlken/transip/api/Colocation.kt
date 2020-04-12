package nl.wouterbohlken.transip.api

import nl.wouterbohlken.transip.client.colocation.ColocationsClient
import nl.wouterbohlken.transip.client.colocation.IpAddressesClient
import nl.wouterbohlken.transip.client.colocation.RemoteHandsClient

class Colocation(val token: String) {
  private lateinit var colocationClient: ColocationsClient
  private lateinit var ipAddressesClient: IpAddressesClient
  private lateinit var remoteHandsClient: RemoteHandsClient

  fun colocations(): ColocationsClient {
    if (!::colocationClient.isInitialized) {
      colocationClient = ColocationsClient(token)
    }
    return colocationClient
  }

  fun ipAddresses(colocationName: String): IpAddressesClient {
    if (!::ipAddressesClient.isInitialized) {
      ipAddressesClient = IpAddressesClient(token, colocationName)
    } else {
      ipAddressesClient.colocationName = colocationName
    }
    return ipAddressesClient
  }

  fun remoteHands(colocationName: String): RemoteHandsClient {
    if (!::remoteHandsClient.isInitialized) {
      remoteHandsClient = RemoteHandsClient(token, colocationName)
    } else {
      remoteHandsClient.colocationName = colocationName
    }
    return remoteHandsClient
  }
}