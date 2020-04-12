package nl.wouterbohlken.transip.examples

import nl.wouterbohlken.transip.api.TransipAPI

class GeneralExamples {
  val api = TransipAPI(TransipAPI.demoToken)

  fun doStuff() {
    getProducts()
    getProductElements()
  }

  fun getProducts() {
    val products = api.general.products().get()
    println(products.vps[0].name)
  }

  fun getProductElements() {
    val products = api.general.products().get()
    val productElements = api.general.productElements(products.vps[0].name).list()
    println(productElements[0].name)
  }
}