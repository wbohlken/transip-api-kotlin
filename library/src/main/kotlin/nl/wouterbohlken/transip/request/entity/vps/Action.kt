package nl.wouterbohlken.transip.request.entity.vps

class Action(): HashMap<String, String>() {
  private constructor(action: String) : this() {
    this["action"] = action
  }

  companion object {
    fun stop(): Action = Action("stop")

    fun start(): Action = Action("start")

    fun reset(): Action = Action("reset")

    fun handover(targetCustomerName: String): Action {
      val vpsAction = Action("handover")
      vpsAction["targetCustomerName"] = targetCustomerName
      return vpsAction
    }
  }
}