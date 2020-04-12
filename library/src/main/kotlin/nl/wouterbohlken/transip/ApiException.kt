package nl.wouterbohlken.transip

import java.lang.Exception

class ApiException(message: String, val httpCode: Int) : Exception(message)