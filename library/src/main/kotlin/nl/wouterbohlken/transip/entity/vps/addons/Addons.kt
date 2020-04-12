package nl.wouterbohlken.transip.entity.vps.addons

import nl.wouterbohlken.transip.entity.Entity

class Addons(
  val active: List<Active>,
  val cancellable: List<Cancellable>,
  val available: List<Available>
): Entity() {
  override fun getIdentifier(): String = ""
}