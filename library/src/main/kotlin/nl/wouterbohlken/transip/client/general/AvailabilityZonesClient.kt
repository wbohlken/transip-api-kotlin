package nl.wouterbohlken.transip.client.general

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.general.AvailabilityZone
import java.lang.reflect.Type

class AvailabilityZonesClient(token: String) : Client<AvailabilityZone>(token) {

  override fun getEndpoint(): String = "availability-zones"

  override fun getItemType(): Type = AvailabilityZone::class.java

  override fun getItemTypeArray(): Type = Array<AvailabilityZone>::class.java

  override fun getIdentifierNameSingular(): String = ""

  override fun getIdentifierNamePlural(): String = "availabilityZones"
}