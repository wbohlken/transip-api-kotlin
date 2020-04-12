package nl.wouterbohlken.transip.entity

class MailService(
  val username: String,
  val password: String,
  val usage: Int,
  val quota: Int,
  val dnsTxt: String
): Entity() {
  override fun getIdentifier(): String = ""
}