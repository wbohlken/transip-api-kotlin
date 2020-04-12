package nl.wouterbohlken.transip.client.haip

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.haip.StatusReport
import nl.wouterbohlken.transip.entity.haip.StatusReportResponse
import java.lang.reflect.Type

class StatusReportsClient(token: String, var haipName: String) : Client<StatusReportResponse>(token) {

  override fun getEndpoint(): String = "haips/$haipName/status-reports"

  override fun getItemType(): Type = StatusReportResponse::class.java

  override fun getItemTypeArray(): Type = Array<StatusReportResponse>::class.java

  override fun getIdentifierNameSingular(): String = "statusReport"

  override fun getIdentifierNamePlural(): String = "statusReport"
}