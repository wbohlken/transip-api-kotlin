package nl.wouterbohlken.transip.entity.general

import nl.wouterbohlken.transip.Serializable

class AvailabilityZone(
  val name: String,
  val country: String,
  val isDefault: Boolean
) : Serializable