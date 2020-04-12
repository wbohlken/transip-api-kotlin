package nl.wouterbohlken.transip.examples

import nl.wouterbohlken.transip.api.TransipAPI
import nl.wouterbohlken.transip.request.entity.haip.CreatePortConfiguration
import nl.wouterbohlken.transip.request.entity.haip.Order

class HaipExamples {
  val api = TransipAPI(TransipAPI.demoToken)

  fun doStuff() {
    getHaips()
    order()
    update()
    cancel()

    listCertificates()
    addCertificate()
    addLetsEncrypt()
    detachCertificate()

    getIpAddresses()
    setIpAddresses()
    detachIpAddresses()

    getPortConfigurations()
    createPortConfiguration()
    updatePortConfiguration()
    removePortConfiguration()

    getStatusReport()
  }

  fun getHaips() {
    val haips = api.haip.haips().list()
    println(haips[0].name)
  }

  fun order() {
    val haipProduct = api.general.products().get().haip[0]
    api.haip.haips().order(Order(haipProduct.name))
  }

  fun update() {
    val haip = api.haip.haips().list()[0]
    haip.description = "test"
    api.haip.haips().update(haip)
  }

  fun cancel() {
    val haip = api.haip.haips().list()[0]
    api.haip.haips().cancel(haip)
  }

  fun listCertificates() {
    val haip = api.haip.haips().list()[0]
    val certificates = api.haip.certificates(haip.getIdentifier()).list()
    println(certificates[0].commonName)
  }

  fun addCertificate() {
    val haip = api.haip.haips().list()[0]
    val domain = api.domain.domains().list()[0]
    val certificate = api.domain.ssl(domain.getIdentifier()).list()[0]
    api.haip.certificates(haip.getIdentifier()).addExisting(certificate)
  }

  fun addLetsEncrypt() {
    val haip = api.haip.haips().list()[0]
    api.haip.certificates(haip.getIdentifier()).addLetsEncrypt("example.com")
  }

  fun detachCertificate() {
    val haip = api.haip.haips().list()[0]
    val domain = api.domain.domains().list()[0]
    val certificate = api.domain.ssl(domain.getIdentifier()).list()[0]
    api.haip.certificates(haip.getIdentifier()).detach(certificate)
  }

  fun getIpAddresses() {
    val haip = api.haip.haips().list()[0]
    val ipAddresses = api.haip.ipAddresses(haip.name).list()
    println(ipAddresses[0])
  }

  fun setIpAddresses() {
    val haip = api.haip.haips().list()[0]
    val ipAddresses = api.haip.ipAddresses(haip.name).list()
    api.haip.ipAddresses(haip.getIdentifier()).setAttachedIps(ipAddresses.toList())
  }

  fun detachIpAddresses() {
    val haip = api.haip.haips().list()[0]
    api.haip.ipAddresses(haip.getIdentifier()).detachAll()
  }

  fun getPortConfigurations() {
    val haip = api.haip.haips().list()[0]
    val portConfigurations = api.haip.portConfigurations(haip.name).list()
    println(portConfigurations[0].sourcePort)
  }

  fun createPortConfiguration() {
    val haip = api.haip.haips().list()[0]
    val portConfiguration = CreatePortConfiguration("Website Traffic", 443, 443, "https", "on")
    api.haip.portConfigurations(haip.getIdentifier()).create(portConfiguration)
  }

  fun updatePortConfiguration() {
    val haip = api.haip.haips().list()[0]
    val portConfiguration = api.haip.portConfigurations(haip.getIdentifier()).list()[0]
    portConfiguration.name = "test"
    api.haip.portConfigurations(haip.getIdentifier()).update(portConfiguration)
  }

  fun removePortConfiguration() {
    val haip = api.haip.haips().list()[0]
    val portConfiguration = api.haip.portConfigurations(haip.getIdentifier()).list()[0]
    api.haip.portConfigurations(haip.getIdentifier()).remove(portConfiguration)
  }

  fun getStatusReport() {
    val haip = api.haip.haips().list()[0]
    val statusReport = api.haip.statusReports(haip.getIdentifier()).get()
    println(statusReport.statusReport[0].ipAddress)
  }
}