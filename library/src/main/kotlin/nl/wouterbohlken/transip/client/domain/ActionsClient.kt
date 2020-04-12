package nl.wouterbohlken.transip.client.domain

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.domain.Action
import java.lang.reflect.Type

class ActionsClient(token: String, var domainName: String) : Client<Action>(token) {

  override fun getEndpoint(): String = "domain/$domainName/actions"

  override fun getItemType(): Type = Action::class.java

  override fun getItemTypeArray(): Type = Array<Action>::class.java

  override fun getIdentifierNameSingular(): String = "action"

  override fun getIdentifierNamePlural(): String = ""
}