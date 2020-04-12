package nl.wouterbohlken.transip.request.entity.vps

class RevertSnapshot() : HashMap<String, String>() {
  constructor(destinationVpsName: String?) : this() {
    if (!destinationVpsName.isNullOrEmpty()) {
      this["destinationVpsName"] = destinationVpsName
    }
  }
}