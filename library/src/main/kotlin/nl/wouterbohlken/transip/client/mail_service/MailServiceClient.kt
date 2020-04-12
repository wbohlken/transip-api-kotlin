package nl.wouterbohlken.transip.client.mail_service

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.MailService
import nl.wouterbohlken.transip.entity.domain.Domain
import nl.wouterbohlken.transip.request.entity.mail_service.AddDnsEntriesToDomain
import java.lang.reflect.Type

class MailServiceClient(token: String) : Client<MailService>(token) {

  override fun getEndpoint(): String = "mail-service"

  override fun getItemType(): Type = MailService::class.java

  override fun getItemTypeArray(): Type = Array<MailService>::class.java

  override fun getIdentifierNameSingular(): String = "mailServiceInformation"

  override fun getIdentifierNamePlural(): String = "mailServiceInformation"

  fun regenerate() = patch("", mapOf())

  fun addDnsEntriesToDomains(domainNames: List<String>) = post(AddDnsEntriesToDomain(domainNames))

  fun addDnsEntriesToDomain(domainName: String) = addDnsEntriesToDomains(listOf(domainName))

  fun addDnsEntriesToDomain(domain: Domain) = addDnsEntriesToDomain(domain.name)
}