package nl.wouterbohlken.transip.api

import nl.wouterbohlken.transip.client.account.InvoiceItemsClient
import nl.wouterbohlken.transip.client.account.InvoicesClient

class Account(val token: String) {
  private val invoiceClient = InvoicesClient(token)
  private lateinit var invoiceItemsClient: InvoiceItemsClient

  fun invoices(): InvoicesClient {
    return invoiceClient
  }

  fun invoiceItems(invoiceNumber: String): InvoiceItemsClient {
    if (!::invoiceItemsClient.isInitialized) {
      invoiceItemsClient = InvoiceItemsClient(token, invoiceNumber)
    } else {
      invoiceItemsClient.invoiceNumber = invoiceNumber
    }
    return invoiceItemsClient
  }
}