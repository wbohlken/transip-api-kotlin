package nl.wouterbohlken.transip.entity

class MonitoringContact(
  var name: String,
  var telephone: String,
  var email: String,
  val id: Int? = null
): Entity() {
  override fun getIdentifier(): String = id.toString()
}