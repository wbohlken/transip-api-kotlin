package nl.wouterbohlken.transip.client.domain

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.domain.Availability
import java.lang.reflect.Type

class DomainAvailabilityClient(token: String) : Client<Availability>(token) {

  override fun getEndpoint(): String = "domain-availability"

  override fun getItemType(): Type = Availability::class.java

  override fun getItemTypeArray(): Type = Array<Availability>::class.java

  override fun getIdentifierNameSingular(): String = ""

  override fun getIdentifierNamePlural(): String = "availability"
}