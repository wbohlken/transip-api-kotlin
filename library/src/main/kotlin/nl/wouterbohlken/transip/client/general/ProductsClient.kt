package nl.wouterbohlken.transip.client.general

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.general.ProductList
import java.lang.reflect.Type

class ProductsClient(token: String) : Client<ProductList>(token) {

  override fun getEndpoint(): String = "products"

  override fun getItemType(): Type = ProductList::class.java

  override fun getItemTypeArray(): Type = ProductList::class.java

  override fun getIdentifierNameSingular(): String = "products"

  override fun getIdentifierNamePlural(): String = ""
}