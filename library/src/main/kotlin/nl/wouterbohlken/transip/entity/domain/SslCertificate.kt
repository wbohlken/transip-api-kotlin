package nl.wouterbohlken.transip.entity.domain

import nl.wouterbohlken.transip.entity.Entity

class SslCertificate(
  val certificateId: Int,
  val commonName: String,
  val expirationDate: String,
  val status: String
): Entity() {
  override fun getIdentifier(): String = certificateId.toString()
}