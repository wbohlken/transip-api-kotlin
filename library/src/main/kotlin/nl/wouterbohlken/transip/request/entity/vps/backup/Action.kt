package nl.wouterbohlken.transip.request.entity.vps.backup

class Action(): HashMap<String, String>() {
  private constructor(action: String, description: String? = null) : this() {
    this["action"] = action
    if (!description.isNullOrEmpty()) {
      this["description"] = description
    }
  }

  companion object {
    fun revert(): Action = Action("revert")

    fun convertToSnapshot(description: String? = null): Action = Action("convert", description)
  }
}