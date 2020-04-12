package nl.wouterbohlken.transip.entity.vps.usage

import nl.wouterbohlken.transip.entity.Entity

class Usage(
  val cpu: List<Cpu>,
  val disk: List<Disk>,
  val network: List<Network>
): Entity() {
  override fun getIdentifier(): String = ""
}