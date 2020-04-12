package nl.wouterbohlken.transip.request.entity.mail_service

import nl.wouterbohlken.transip.request.entity.RequestEntity

class AddDnsEntriesToDomain(val domainNames: List<String>) : RequestEntity()