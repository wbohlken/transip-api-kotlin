package nl.wouterbohlken.transip.request.entity.haip

import nl.wouterbohlken.transip.request.entity.RequestEntity

class AddLetsEncryptCertificate(val commonName: String) : RequestEntity()