package nl.wouterbohlken.transip.entity

import nl.wouterbohlken.transip.Serializable

abstract class Entity: Serializable {
  abstract fun getIdentifier(): String
}