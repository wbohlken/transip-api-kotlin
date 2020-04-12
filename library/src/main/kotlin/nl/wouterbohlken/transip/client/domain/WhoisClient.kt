package nl.wouterbohlken.transip.client.domain

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.domain.Whois
import java.lang.reflect.Type

class WhoisClient(token: String, var domainName: String) : Client<Whois>(token) {

  override fun getEndpoint(): String = "domain/$domainName/ssl"

  override fun getItemType(): Type = Whois::class.java

  override fun getItemTypeArray(): Type = Array<Whois>::class.java

  override fun getIdentifierNameSingular(): String = ""

  override fun getIdentifierNamePlural(): String = "whois"
}