package nl.wouterbohlken.transip.request.entity.vps

import nl.wouterbohlken.transip.request.entity.RequestEntity

class OrderAddons(val addons : List<String>) : RequestEntity()