package nl.wouterbohlken.transip.entity.haip

import nl.wouterbohlken.transip.entity.Entity

class StatusReportResponse(val statusReport: Array<StatusReport>): Entity() {
  override fun getIdentifier(): String = ""
}