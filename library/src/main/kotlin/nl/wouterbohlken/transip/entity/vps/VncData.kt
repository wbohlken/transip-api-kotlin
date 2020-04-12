package nl.wouterbohlken.transip.entity.vps

import nl.wouterbohlken.transip.Serializable

class VncData(
  val host: String,
  val path: String,
  val url: String,
  val token: String,
  val password: String
): Serializable