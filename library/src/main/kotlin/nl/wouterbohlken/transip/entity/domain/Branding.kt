package nl.wouterbohlken.transip.entity.domain

import nl.wouterbohlken.transip.entity.Entity

class Branding(
  var companyName: String,
  var supportEmail: String,
  var companyUrl: String,
  var termsOfUsageUrl: String,
  var bannerLine1: String,
  var bannerLine2: String,
  var bannerLine3: String
): Entity() {
  override fun getIdentifier(): String = ""
}