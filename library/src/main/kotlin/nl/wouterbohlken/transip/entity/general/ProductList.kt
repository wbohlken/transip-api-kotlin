package nl.wouterbohlken.transip.entity.general

import nl.wouterbohlken.transip.Serializable

class ProductList(
  val vps: List<Product>,
  val vpsAddon: List<Product>,
  val haip: List<Product>,
  val bigStorage: List<Product>,
  val privateNetworks: List<Product>
) : Serializable