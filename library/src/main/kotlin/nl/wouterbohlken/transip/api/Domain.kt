package nl.wouterbohlken.transip.api

import nl.wouterbohlken.transip.client.domain.*

class Domain(val token: String) {
  private val domainClient = DomainsClient(token)
  private lateinit var brandingClient: BrandingClient
  private lateinit var contactsClient: ContactsClient
  private lateinit var dnsClient: DnsClient
  private lateinit var dnssecClient: DnssecClient
  private lateinit var nameserversClient: NameserversClient
  private lateinit var actionsClient: ActionsClient
  private lateinit var sslClient: SslClient
  private lateinit var whoisClient: WhoisClient
  private val availabilityClient = DomainAvailabilityClient(token)
  private val tldClient = TldClient(token)

  fun domains(): DomainsClient {
    return domainClient
  }

  fun branding(domainName: String): BrandingClient {
    if (!::brandingClient.isInitialized) {
      brandingClient = BrandingClient(token, domainName)
    } else {
      brandingClient.domainName = domainName
    }
    return brandingClient
  }

  fun contacts(domainName: String): ContactsClient {
    if (!::contactsClient.isInitialized) {
      contactsClient = ContactsClient(token, domainName)
    } else {
      contactsClient.domainName = domainName
    }
    return contactsClient
  }

  fun dns(domainName: String): DnsClient {
    if (!::dnsClient.isInitialized) {
      dnsClient = DnsClient(token, domainName)
    } else {
      dnsClient.domainName = domainName
    }
    return dnsClient
  }

  fun dnssec(domainName: String): DnssecClient {
    if (!::dnssecClient.isInitialized) {
      dnssecClient = DnssecClient(token, domainName)
    } else {
      dnssecClient.domainName = domainName
    }
    return dnssecClient
  }

  fun nameservers(domainName: String): NameserversClient {
    if (!::nameserversClient.isInitialized) {
      nameserversClient = NameserversClient(token, domainName)
    } else {
      nameserversClient.domainName = domainName
    }
    return nameserversClient
  }

  fun actions(domainName: String): ActionsClient {
    if (!::actionsClient.isInitialized) {
      actionsClient = ActionsClient(token, domainName)
    } else {
      actionsClient.domainName = domainName
    }
    return actionsClient
  }

  fun ssl(domainName: String): SslClient {
    if (!::sslClient.isInitialized) {
      sslClient = SslClient(token, domainName)
    } else {
      sslClient.domainName = domainName
    }
    return sslClient
  }

  fun whois(domainName: String): WhoisClient {
    if (!::whoisClient.isInitialized) {
      whoisClient = WhoisClient(token, domainName)
    } else {
      whoisClient.domainName = domainName
    }
    return whoisClient
  }

  fun availability(domainName: String): DomainAvailabilityClient {
    return availabilityClient
  }

  fun tld(domainName: String): TldClient {
    return tldClient
  }
}