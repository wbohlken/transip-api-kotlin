package nl.wouterbohlken.transip.client.domain

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.domain.Contact
import nl.wouterbohlken.transip.entity.domain.Dns
import java.lang.reflect.Type

class DnsClient(token: String, var domainName: String) : Client<Dns>(token) {

  override fun getEndpoint(): String = "domain/$domainName/dns"

  override fun getItemType(): Type = Dns::class.java

  override fun getItemTypeArray(): Type = Array<Dns>::class.java

  override fun getIdentifierNameSingular(): String = ""

  override fun getIdentifierNamePlural(): String = "dnsEntries"

  fun add(dns: Dns) = post(dns)

  fun updateSingle(dns: Dns) = patch(dns)
}