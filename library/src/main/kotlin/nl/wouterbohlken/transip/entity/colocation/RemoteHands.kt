package nl.wouterbohlken.transip.entity.colocation

import nl.wouterbohlken.transip.entity.Entity

class RemoteHands(
  val coloName: String,
  val contactName: String,
  val phoneNumber: String,
  val expectedDuration: Int,
  val instructions: String
): Entity() {
  override fun getIdentifier(): String = ""
}