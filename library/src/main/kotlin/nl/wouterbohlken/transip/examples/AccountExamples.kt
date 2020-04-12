package nl.wouterbohlken.transip.examples

import nl.wouterbohlken.transip.api.TransipAPI

class AccountExamples {
  val api = TransipAPI(TransipAPI.demoToken)

  fun doStuff() {
    getInvoices()
    getInvoiceItems() // TODO: Internal server error
  }

  fun getInvoices() {
    val invoices = api.account.invoices().list()
    println(invoices[0].invoiceNumber)
  }

  fun getInvoiceItems() {
    val invoices = api.account.invoices().list()
    val invoiceItems = api.account.invoiceItems(invoices[0].invoiceNumber).list()
    println(invoiceItems[0].totalAmount.toString())
  }
}