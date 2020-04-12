package nl.wouterbohlken.transip.entity.vps.firewall

import nl.wouterbohlken.transip.entity.Entity

class Firewall(
  val isEnabled: Boolean,
  val ruleSet: List<Rule>
): Entity() {
  override fun getIdentifier(): String = isEnabled.toString()
}