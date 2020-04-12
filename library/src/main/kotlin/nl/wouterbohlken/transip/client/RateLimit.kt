package nl.wouterbohlken.transip.client

class RateLimit(val limit: Int, val remaining: Int, val reset: Int) {
  fun hasExceeded() = limit == 0 && !isReset()

  fun isReset() = reset < (System.currentTimeMillis() / 1000)
}