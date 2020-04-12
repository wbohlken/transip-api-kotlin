package nl.wouterbohlken.transip.request.entity.private_network

class Action(): HashMap<String, String>() {
  private constructor(action: String, vpsName: String) : this() {
    this["action"] = action
    this["vpsName"] = vpsName
  }

  companion object {
    fun attachVps(vpsName: String): Action = Action("attachvps", vpsName)

    fun detachVps(vpsName: String): Action = Action("detachvps", vpsName)
  }
}