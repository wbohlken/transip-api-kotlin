package nl.wouterbohlken.transip.entity.domain

import nl.wouterbohlken.transip.entity.Entity

class Tld(
  val name: String,
  val price: Int,
  val recurringPrice: Int,
  val capabilities: List<String>,
  val minLength: Int,
  val maxLength: Int,
  val registrationPeriodLength: Int,
  val cancelTimeFrame: Int
): Entity() {
  override fun getIdentifier(): String = name
}