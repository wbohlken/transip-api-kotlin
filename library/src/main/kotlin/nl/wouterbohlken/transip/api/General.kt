package nl.wouterbohlken.transip.api

import nl.wouterbohlken.transip.client.general.AvailabilityZonesClient
import nl.wouterbohlken.transip.client.general.ProductElementsClient
import nl.wouterbohlken.transip.client.general.ProductsClient

class General(val token: String) {
  private val productsClient = ProductsClient(token)
  private lateinit var productElementsClient: ProductElementsClient
  private val availabilityZonesClient = AvailabilityZonesClient(token)

  fun products(): ProductsClient {
    return productsClient
  }

  fun productElements(productName: String): ProductElementsClient {
    if (!::productElementsClient.isInitialized) {
      productElementsClient = ProductElementsClient(token, productName)
    } else {
      productElementsClient.productName = productName
    }
    return productElementsClient
  }

  fun availabilityZones(): AvailabilityZonesClient {
    return availabilityZonesClient
  }
}