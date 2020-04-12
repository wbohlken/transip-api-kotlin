package nl.wouterbohlken.transip.request.entity

class EndTime(): HashMap<String, String>() {
  private constructor(endTime: String) : this() {
    this["endTime"] = endTime
  }

  companion object {
    fun end(): EndTime =
      EndTime("end")

    fun immediately(): EndTime =
      EndTime("immediately")
  }
}