package nl.wouterbohlken.transip.request.entity.vps.addons

import nl.wouterbohlken.transip.request.entity.RequestEntity

class Cancel(
  val addonName: String
): RequestEntity()