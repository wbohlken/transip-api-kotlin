package nl.wouterbohlken.transip.client.colocation

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.colocation.Colocation
import java.lang.reflect.Type

class ColocationsClient(token: String) : Client<Colocation>(token) {

  override fun getEndpoint(): String = "colocations"

  override fun getItemType(): Type = Colocation::class.java

  override fun getItemTypeArray(): Type = Array<Colocation>::class.java

  override fun getIdentifierNameSingular(): String = "colocation"

  override fun getIdentifierNamePlural(): String = "colocations"
}