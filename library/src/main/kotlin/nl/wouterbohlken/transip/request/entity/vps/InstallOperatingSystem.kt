package nl.wouterbohlken.transip.request.entity.vps

import nl.wouterbohlken.transip.request.entity.RequestEntity

class InstallOperatingSystem(
  val operatingSystemName: String,
  val hostname: String? = null,
  val base64InstallText: String? = null
): RequestEntity()