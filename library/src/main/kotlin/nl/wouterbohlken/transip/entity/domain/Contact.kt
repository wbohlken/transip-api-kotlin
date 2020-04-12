package nl.wouterbohlken.transip.entity.domain

import nl.wouterbohlken.transip.entity.Entity

class Contact(
 val type: String,
 val firstName: String,
 val lastName: String,
 val companyName: String,
 val companyKvk: String,
 val companyType: String,
 val street: String,
 val number: String,
 val postalCode: String,
 val city: String,
 val phoneNumber: String,
 val faxNumber: String,
 val email: String,
 val country: String
): Entity() {
  override fun getIdentifier(): String = ""
}