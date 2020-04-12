package nl.wouterbohlken.transip.request.entity.vps

import nl.wouterbohlken.transip.request.entity.RequestEntity

class Order(
  val productName: String,
  val operatingSystem: String,
  val availabilityZone: String? = null,
  val addons: String? = null,
  val hostname: String? = null,
  val description: String? = null,
  val base64InstallText: String? = null
): RequestEntity()