package nl.wouterbohlken.transip.client.general

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.general.ProductElement
import java.lang.reflect.Type

class ProductElementsClient(token: String, var productName: String) : Client<ProductElement>(token) {

  override fun getEndpoint(): String = "products/$productName/elements"

  override fun getItemType(): Type = ProductElement::class.java

  override fun getItemTypeArray(): Type = Array<ProductElement>::class.java

  override fun getIdentifierNameSingular(): String = ""

  override fun getIdentifierNamePlural(): String = "productElements"
}