package nl.wouterbohlken.transip.entity

class PrivateNetwork(
  val name: String,
  var description: String,
  val isBlocked: Boolean,
  val isLocked: Boolean,
  val vpsNames: List<String>
): Entity() {
  override fun getIdentifier(): String = name
}