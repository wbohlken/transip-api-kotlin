package nl.wouterbohlken.transip.entity.vps.addons

class Available(name: String, description: String, price: Int, recurringPrice: Int) :
  Addon(name, description, price, recurringPrice) {
}