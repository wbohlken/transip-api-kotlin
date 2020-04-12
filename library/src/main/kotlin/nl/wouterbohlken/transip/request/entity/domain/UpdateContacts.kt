package nl.wouterbohlken.transip.request.entity.domain

import nl.wouterbohlken.transip.entity.Entity
import nl.wouterbohlken.transip.entity.domain.Contact

class UpdateContacts(val contacts: List<Contact>) : Entity() {
  override fun getIdentifier(): String {
    return "" // TODO
  }
}