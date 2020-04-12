package nl.wouterbohlken.transip.request.entity.big_storage.backup

class Action(): HashMap<String, String>() {
  private constructor(action: String) : this() {
    this["action"] = action
  }

  companion object {
    fun revert(): Action = Action("revert")
  }
}