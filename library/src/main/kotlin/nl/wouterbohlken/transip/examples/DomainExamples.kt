package nl.wouterbohlken.transip.examples

import nl.wouterbohlken.transip.api.TransipAPI

class DomainExamples {
  val api = TransipAPI(TransipAPI.demoToken)

  fun doStuff() {
    getDomains()
    getDomain()
    registerDomain()
    transferDomain()

    getAvailabilityZones()
  }

  fun getDomains() {
    val domains = api.domain.domains().list()
    println(domains[0].name)
  }

  fun getDomain() {
    val domains = api.domain.domains().list()
    val domain = api.domain.domains().get(domains[0].name)
    println(domain.name)
  }

  fun registerDomain() {
    api.domain.domains().register("tranip-api-test.nl")
  }

  fun transferDomain() {
    api.domain.domains().transfer("tranip-api-test.nl", "test")
  }

  fun updateDomain() {
    val domain = api.domain.domains().list()[0]
    domain.isWhitelabel = true
    domain.tags.add("test")
    api.domain.domains().updateDomain(domain)
  }

  fun cancelDomain() {
    api.domain.domains().cancel("tranip-api-test.nl")
  }

  private fun getAvailabilityZones() {
    val availabilityZones = api.general.availabilityZones().list()
    println(availabilityZones[0].name)
  }
}