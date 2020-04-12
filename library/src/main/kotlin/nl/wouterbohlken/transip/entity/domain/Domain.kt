package nl.wouterbohlken.transip.entity.domain

import nl.wouterbohlken.transip.entity.Entity

class Domain(
  val name: String,
  val authCode: String? = null,
  var isTransferLocked: Boolean,
  val registrationDate: String,
  val renewalDate: String,
  var isWhitelabel: Boolean,
  val cancellationDate: String? = null,
  val cancellationStatus: String? = null,
  val isDnsOnly: Boolean,
  var tags: MutableList<String>
): Entity() {
  override fun getIdentifier(): String {
    return name;
  }
}