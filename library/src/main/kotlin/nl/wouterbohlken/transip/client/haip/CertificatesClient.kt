package nl.wouterbohlken.transip.client.haip

import nl.wouterbohlken.transip.client.Client
import nl.wouterbohlken.transip.entity.domain.SslCertificate
import nl.wouterbohlken.transip.entity.haip.Certificate
import nl.wouterbohlken.transip.request.entity.haip.AddExistingCertificate
import nl.wouterbohlken.transip.request.entity.haip.AddLetsEncryptCertificate
import java.lang.reflect.Type

class CertificatesClient(token: String, var haipName: String) : Client<Certificate>(token) {

  override fun getEndpoint(): String = "haips/$haipName/certificates"

  override fun getItemType(): Type = Certificate::class.java

  override fun getItemTypeArray(): Type = Array<Certificate>::class.java

  override fun getIdentifierNameSingular(): String = "certificate"

  override fun getIdentifierNamePlural(): String = "certificates"

  fun addExisting(sslCertificateId: Int) = post(AddExistingCertificate(sslCertificateId))

  fun addExisting(sslCertificate: SslCertificate) = addExisting(sslCertificate.certificateId)

  fun addLetsEncrypt(commonName: String) = post(AddLetsEncryptCertificate(commonName))

  fun detach(sslCertificateId: Int) = delete(sslCertificateId.toString())

  fun detach(sslCertificate: SslCertificate) = detach(sslCertificate.certificateId)
}