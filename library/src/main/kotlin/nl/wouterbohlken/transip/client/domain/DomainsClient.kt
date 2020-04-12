package nl.wouterbohlken.transip.client.domain

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.domain.Domain
import nl.wouterbohlken.transip.request.entity.domain.Register
import nl.wouterbohlken.transip.request.entity.domain.Transfer
import java.lang.reflect.Type

class DomainsClient(token: String) : Client<Domain>(token) {

  override fun getEndpoint(): String = "domains"

  override fun getItemType(): Type = Domain::class.java

  override fun getItemTypeArray(): Type = Array<Domain>::class.java

  override fun getIdentifierNameSingular(): String = "domain"

  override fun getIdentifierNamePlural(): String = "domains"

  fun register(registerRequest: Register) = post(registerRequest)

  fun register(domainName: String) = register(Register(domainName))

  fun transfer(transferRequest: Transfer) = post(transferRequest)

  fun transfer(domainName: String, authCode: String) = transfer(Transfer(domainName, authCode))

  fun updateDomain(domain: Domain) = put(domain)

  fun cancel(domain: Domain) = delete(domain)

  fun cancel(domainName: String) = delete(domainName)
}