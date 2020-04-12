package nl.wouterbohlken.transip.api

import nl.wouterbohlken.transip.client.private_network.PrivateNetworkClient

class PrivateNetwork(val token: String) {
  private var privateNetworkClient = PrivateNetworkClient(token)

  fun privateNetworks(): PrivateNetworkClient {
    return privateNetworkClient
  }
}