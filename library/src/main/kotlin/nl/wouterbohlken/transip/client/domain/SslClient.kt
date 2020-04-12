package nl.wouterbohlken.transip.client.domain

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.domain.SslCertificate
import java.lang.reflect.Type

class SslClient(token: String, var domainName: String) : Client<SslCertificate>(token) {

  override fun getEndpoint(): String = "domain/$domainName/ssl"

  override fun getItemType(): Type = SslCertificate::class.java

  override fun getItemTypeArray(): Type = Array<SslCertificate>::class.java

  override fun getIdentifierNameSingular(): String = "certificate"

  override fun getIdentifierNamePlural(): String = "certificates"
}