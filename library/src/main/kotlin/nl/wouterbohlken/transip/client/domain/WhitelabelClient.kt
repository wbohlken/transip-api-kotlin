package nl.wouterbohlken.transip.client.domain

import nl.wouterbohlken.transip.client.Client
import java.lang.reflect.Type

class WhitelabelClient(token: String, var domainName: String) : Client<String>(token) {

  override fun getEndpoint(): String = "domain/$domainName/whitelabel"

  override fun getItemType(): Type = String::class.java

  override fun getItemTypeArray(): Type = Array<String>::class.java

  override fun getIdentifierNameSingular(): String = ""

  override fun getIdentifierNamePlural(): String = ""
}