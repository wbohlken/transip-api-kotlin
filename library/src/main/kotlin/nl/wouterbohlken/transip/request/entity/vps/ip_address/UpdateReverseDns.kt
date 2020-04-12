package nl.wouterbohlken.transip.request.entity.vps.ip_address

import nl.wouterbohlken.transip.entity.vps.IpAddress
import nl.wouterbohlken.transip.request.entity.RequestEntity

class UpdateReverseDns(val ipAddress: IpAddress): RequestEntity()