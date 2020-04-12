package nl.wouterbohlken.transip.entity.vps.firewall

class Rule(
  var description: String,
  var startPort: Int,
  var endPort: Int,
  var protocol: String,
  var whitelist: List<String>
)