package nl.wouterbohlken.transip.client.domain

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.domain.Branding
import java.lang.reflect.Type

class BrandingClient(token: String, var domainName: String) : Client<Branding>(token) {

  override fun getEndpoint(): String = "domain/$domainName/branding"

  override fun getItemType(): Type = Branding::class.java

  override fun getItemTypeArray(): Type = Array<Branding>::class.java

  override fun getIdentifierNameSingular(): String = ""

  override fun getIdentifierNamePlural(): String = "branding"

  fun updateBranding(branding: Branding) = put(branding)
}