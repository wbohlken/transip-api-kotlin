package nl.wouterbohlken.transip.entity.vps.addons

class Cancellable(name: String, description: String, price: Int, recurringPrice: Int) :
  Addon(name, description, price, recurringPrice) {
}