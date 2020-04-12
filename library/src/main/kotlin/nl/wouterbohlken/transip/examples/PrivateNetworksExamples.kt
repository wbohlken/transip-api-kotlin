package nl.wouterbohlken.transip.examples

import nl.wouterbohlken.transip.api.TransipAPI

class PrivateNetworksExamples {
  val api = TransipAPI(TransipAPI.demoToken)

  fun doStuff() {
    listPrivateNetworks()
    getPrivateNetwork()
    orderPrivateNetwork()
    updatePrivateNetwork()
    attachVpsToPrivateNetwork()
    detachVpsFromPrivateNetwork()
    cancelPrivateNetwork()
  }

  private fun listPrivateNetworks() {
    val privateNetworks = api.privateNetwork.privateNetworks().list()
    println(privateNetworks[0].name)
  }

  private fun getPrivateNetwork() {
    val privateNetworks = api.privateNetwork.privateNetworks().list()
    val privateNetwork = api.privateNetwork.privateNetworks().get(privateNetworks[0].getIdentifier())
    println(privateNetwork.name)
  }

  private fun orderPrivateNetwork() {
    api.privateNetwork.privateNetworks().order("test")
  }

  private fun updatePrivateNetwork() {
    val privateNetwork = api.privateNetwork.privateNetworks().list()[0]
    privateNetwork.description = "test"
    api.privateNetwork.privateNetworks().update(privateNetwork)
  }

  private fun attachVpsToPrivateNetwork() {
    val privateNetwork = api.privateNetwork.privateNetworks().list()[0]
    val vps = api.vps.vpses().list()[0]
    api.privateNetwork.privateNetworks().attachVps(privateNetwork, vps)
  }

  private fun detachVpsFromPrivateNetwork() {
    val privateNetwork = api.privateNetwork.privateNetworks().list()[0]
    val vps = api.vps.vpses().list()[0]
    api.privateNetwork.privateNetworks().detachVps(privateNetwork, vps)
  }

  private fun cancelPrivateNetwork() {
    val privateNetwork = api.privateNetwork.privateNetworks().list()[0]
    api.privateNetwork.privateNetworks().cancel(privateNetwork)
  }
}