package nl.wouterbohlken.transip.request.entity.haip

import nl.wouterbohlken.transip.Serializable

class SetAttachedIpAddresses(val ipAddresses: List<String>): Serializable