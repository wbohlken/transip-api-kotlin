package nl.wouterbohlken.transip.client.domain

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.domain.Contact
import nl.wouterbohlken.transip.request.entity.domain.UpdateContacts
import java.lang.reflect.Type

class ContactsClient(token: String, var domainName: String) : Client<Contact>(token) {

  override fun getEndpoint(): String = "domain/$domainName/contacts"

  override fun getItemType(): Type = Contact::class.java

  override fun getItemTypeArray(): Type = Array<Contact>::class.java

  override fun getIdentifierNameSingular(): String = ""

  override fun getIdentifierNamePlural(): String = "contacts"

  fun updateContacts(updateContacts: UpdateContacts) = put(updateContacts)
}