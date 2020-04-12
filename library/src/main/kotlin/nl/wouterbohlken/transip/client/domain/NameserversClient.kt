package nl.wouterbohlken.transip.client.domain

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.domain.Nameserver
import java.lang.reflect.Type

class NameserversClient(token: String, var domainName: String) : Client<Nameserver>(token) {

  override fun getEndpoint(): String = "domain/$domainName/nameservers"

  override fun getItemType(): Type = Nameserver::class.java

  override fun getItemTypeArray(): Type = Array<Nameserver>::class.java

  override fun getIdentifierNameSingular(): String = ""

  override fun getIdentifierNamePlural(): String = "nameservers"
}