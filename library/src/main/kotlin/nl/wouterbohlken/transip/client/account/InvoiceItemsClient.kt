package nl.wouterbohlken.transip.client.account

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.invoice.Invoice
import nl.wouterbohlken.transip.entity.invoice.InvoiceItem
import java.lang.reflect.Type

class InvoiceItemsClient(token: String, var invoiceNumber: String) : Client<Invoice>(token) {

  override fun getEndpoint(): String = "invoices/$invoiceNumber/invoice-items"

  override fun getItemType(): Type = InvoiceItem::class.java

  override fun getItemTypeArray(): Type = Array<InvoiceItem>::class.java

  override fun getIdentifierNameSingular(): String = "invoiceItem"

  override fun getIdentifierNamePlural(): String = "invoiceItems"
}