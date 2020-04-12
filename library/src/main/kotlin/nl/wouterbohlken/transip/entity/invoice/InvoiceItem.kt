package nl.wouterbohlken.transip.entity.invoice

class InvoiceItem(
  val product: String,
  val description: String,
  val isRecurring: Boolean,
  val date: String,
  val quantity: Int,
  val price: Int,
  val priceInclVat: Int,
  val vat: Int,
  val vatPercentage: Int,
  val discounts: List<InvoiceItemDiscount>
)