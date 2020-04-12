package nl.wouterbohlken.transip.client.domain

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.domain.Action
import nl.wouterbohlken.transip.entity.domain.Tld
import java.lang.reflect.Type

class TldClient(token: String) : Client<Tld>(token) {

  override fun getEndpoint(): String = "tlds"

  override fun getItemType(): Type = Tld::class.java

  override fun getItemTypeArray(): Type = Array<Tld>::class.java

  override fun getIdentifierNameSingular(): String = "tld"

  override fun getIdentifierNamePlural(): String = "tlds"
}