package nl.wouterbohlken.transip.request.entity.domain

import nl.wouterbohlken.transip.entity.domain.Contact
import nl.wouterbohlken.transip.entity.domain.Dns
import nl.wouterbohlken.transip.entity.domain.Nameserver
import nl.wouterbohlken.transip.request.entity.RequestEntity

class Register(
  val domainName: String,
  val contacts: List<Contact>? = listOf(),
  val nameservers: List<Nameserver>? = listOf(),
  val dnsEntries: List<Dns>? = listOf()
) : RequestEntity()