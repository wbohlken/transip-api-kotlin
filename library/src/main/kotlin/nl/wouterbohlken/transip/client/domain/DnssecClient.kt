package nl.wouterbohlken.transip.client.domain

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.domain.Contact
import nl.wouterbohlken.transip.entity.domain.Dns
import nl.wouterbohlken.transip.entity.domain.Dnssec
import java.lang.reflect.Type

class DnssecClient(token: String, var domainName: String) : Client<Dnssec>(token) {

  override fun getEndpoint(): String = "domain/$domainName/dnssec"

  override fun getItemType(): Type = Dnssec::class.java

  override fun getItemTypeArray(): Type = Array<Dnssec>::class.java

  override fun getIdentifierNameSingular(): String = ""

  override fun getIdentifierNamePlural(): String = "dnsSecEntries"
}