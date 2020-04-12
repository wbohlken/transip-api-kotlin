package nl.wouterbohlken.transip.entity.invoice

import nl.wouterbohlken.transip.entity.Entity

class Invoice(
  val invoiceNumber: String,
  val creationDate: String,
  val payDate: String,
  val dueDate: String,
  val invoiceStatus: String,
  val currency: String,
  val totalAmount: Int,
  val totalAmountInclVat: Int
): Entity() {
  override fun getIdentifier(): String = invoiceNumber
}