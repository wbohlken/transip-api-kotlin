package nl.wouterbohlken.transip.request.entity.vps

import nl.wouterbohlken.transip.entity.Entity
import nl.wouterbohlken.transip.entity.vps.Vps

class Update(val currentName: String, val vps: Vps): Entity() {

  override fun getIdentifier(): String = currentName
}