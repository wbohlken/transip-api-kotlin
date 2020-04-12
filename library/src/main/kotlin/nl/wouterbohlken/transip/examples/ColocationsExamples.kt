package nl.wouterbohlken.transip.examples

import nl.wouterbohlken.transip.api.TransipAPI
import nl.wouterbohlken.transip.entity.colocation.RemoteHands
import nl.wouterbohlken.transip.request.entity.colocation.CreateIpAddress

class ColocationsExamples {
  val api = TransipAPI(TransipAPI.demoToken)

  fun doStuff() {
    getColocations()
    getColocation()

    getColocationIpAddresses()
    createColocationIpAddress()
    setReverseDnsColocationIpAddress()
    deleteColocationIpAddress()

    createRemoteHandsRequest()
  }

  fun getColocations() {
    val colocations = api.colocation.colocations().list()
    println(colocations[0].name)
  }

  fun getColocation() {
    val colocationIdentifier = api.colocation.colocations().list()[0].getIdentifier()
    val colocation = api.colocation.colocations().get(colocationIdentifier)
    println(colocation.name)
  }

  fun getColocationIpAddresses() {
    val colocation = api.colocation.colocations().list()[0]
    val ipAddresses = api.colocation.ipAddresses(colocation.getIdentifier()).list()
    println(ipAddresses[0].address)
  }

  fun createColocationIpAddress() {
    val colocation = api.colocation.colocations().list()[0]
    api.colocation.ipAddresses(colocation.getIdentifier()).create(CreateIpAddress("2a01:7c8:3:1337::6"))
  }

  fun setReverseDnsColocationIpAddress() {
    val colocation = api.colocation.colocations().list()[0]
    val ipAddress = api.colocation.ipAddresses(colocation.getIdentifier()).list()[0]
    ipAddress.reverseDns = "example.com"
    api.colocation.ipAddresses(colocation.getIdentifier()).setReverseDns(ipAddress)
  }

  fun deleteColocationIpAddress() {
    val colocation = api.colocation.colocations().list()[0]
    val ipAddress = api.colocation.ipAddresses(colocation.getIdentifier()).list()[0]
    api.colocation.ipAddresses(colocation.getIdentifier()).deleteIpAddress(ipAddress)
  }

  fun createRemoteHandsRequest() {
    val colocation = api.colocation.colocations().list()[0]
    val remoteHands = RemoteHands(
      colocation.name,
      "Herman Kaakdorst",
      "+31 612345678",
      15,
      "Reboot server with label Loadbalancer0"
    )
    api.colocation.remoteHands(colocation.getIdentifier()).create(remoteHands)
  }
}