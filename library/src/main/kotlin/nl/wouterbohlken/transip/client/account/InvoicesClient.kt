package nl.wouterbohlken.transip.client.account

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.invoice.Invoice
import java.lang.reflect.Type

class InvoicesClient(token: String) : Client<Invoice>(token) {

  override fun getEndpoint(): String = "invoices"

  override fun getItemType(): Type = Invoice::class.java

  override fun getItemTypeArray(): Type = Array<Invoice>::class.java

  override fun getIdentifierNameSingular(): String = "invoice"

  override fun getIdentifierNamePlural(): String = "invoices"
}