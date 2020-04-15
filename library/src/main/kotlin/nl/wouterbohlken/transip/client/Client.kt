package nl.wouterbohlken.transip.client

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import nl.wouterbohlken.transip.ApiException
import nl.wouterbohlken.transip.Error
import nl.wouterbohlken.transip.Serializable
import nl.wouterbohlken.transip.entity.Entity
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.lang.reflect.Type

abstract class Client<EntityType>(private val token: String) {
  private val httpClient = OkHttpClient()
  private val gson = Gson()

  abstract fun getEndpoint(): String

  /**
   * TODO: pagination
   */
  fun list(): Array<EntityType> {
    val request = buildGetRequest()

    httpClient.newCall(request).execute().use { response ->
      val responseJson = parseResponse(response)
      val responseEntities = (responseJson as JsonObject).get(getIdentifierNamePlural())
      return gson.fromJson(responseEntities, getItemTypeArray())
    }
  }

  fun get(identifier: String = ""): EntityType {
    val request = buildGetRequest(identifier)

    httpClient.newCall(request).execute().use { response ->
      val responseJson = parseResponse(response)
      val responseEntity = (responseJson as JsonObject).get(getIdentifierNameSingular())
      return gson.fromJson(responseEntity, getItemType())
    }
  }

  protected fun post(entity: Serializable) = doRequest(buildPostRequest(entity))

  protected fun put(entity: Entity) = doRequest(buildPutRequest(entity))

  protected fun put(entity: Serializable, identifier: String) = doRequest(buildPutRequest(entity, identifier))

  protected fun patch(identifier: String, body: Map<String, String>) = doRequest(buildPatchRequest(identifier, body))

  protected fun patch(entity: Entity, body: Map<String, String>) =
    doRequest(buildPatchRequest(entity.getIdentifier(), body))

  protected fun patch(entity: Entity) = doRequest(buildPatchRequest("", entity))

  protected fun delete(identifier: String, body: Map<String, String>? = null) =
    doRequest(buildDeleteRequest(identifier, body))

  protected fun delete(entity: Entity, body: Map<String, String>? = null) =
    doRequest(buildDeleteRequest(entity.getIdentifier(), body))

  private fun doRequest(request: Request) {
    httpClient.newCall(request).execute().use { response ->
      parseResponse(response)
    }
  }

  private fun buildGetRequest(urlPath: String = ""): Request {
    return getBuilder()
      .get()
      .url("$apiUrl/${getEndpoint()}/$urlPath")
      .build()
  }

  private fun buildPostRequest(entity: Serializable): Request {
    val requestBodyJson = gson.toJson(entity)
    val requestBody = requestBodyJson.toRequestBody(mediaTypeJson)

    return getBuilder()
      .post(requestBody)
      .url("$apiUrl/${getEndpoint()}")
      .build()
  }

  private fun buildPutRequest(entity: Serializable, identifier: String): Request {
    val requestBodyJson = gson.toJson(entity)
    val requestBody = requestBodyJson.toRequestBody(mediaTypeJson)

    return getBuilder()
      .put(requestBody)
      .url("$apiUrl/${getEndpoint()}/$identifier")
      .build()
  }

  private fun buildPutRequest(entity: Entity): Request = buildPutRequest(entity, entity.getIdentifier())

  private fun buildPatchRequest(identifier: String, body: Map<String, String>): Request {
    val requestBodyJson = gson.toJson(body)
    val requestBody = requestBodyJson.toRequestBody(mediaTypeJson)

    return getBuilder()
      .patch(requestBody)
      .url("$apiUrl/${getEndpoint()}/$identifier")
      .build()
  }

  private fun buildPatchRequest(identifier: String, entity: Serializable): Request {
    val requestBodyJson = gson.toJson(entity)
    val requestBody = requestBodyJson.toRequestBody(mediaTypeJson)

    return getBuilder()
      .patch(requestBody)
      .url("$apiUrl/${getEndpoint()}/$identifier")
      .build()
  }

  private fun buildDeleteRequest(identifier: String, body: Map<String, String>? = null): Request {
    val builder = getBuilder()
      .url("$apiUrl/${getEndpoint()}/$identifier")

    if (body != null) {
      val requestBodyJson = gson.toJson(body)
      val requestBody = requestBodyJson.toRequestBody(mediaTypeJson)
      builder.delete(requestBody)
    } else {
      builder.delete()
    }

    return builder.build()
  }

  private fun getBuilder(): Request.Builder {
    return Request.Builder()
      .header("Authorization", "Bearer $token")
      .header("Content-Type", "application/json")
  }

  private fun parseResponse(response: Response): JsonElement? {
    if (!response.isSuccessful) throwException(response)

    setRateLimit(response)

    val bodyString = response.body?.string()
    if (bodyString.isNullOrBlank()) {
      return null
    }
    val parser = JsonParser()
    return parser.parse(bodyString) as JsonElement
  }

  private fun throwException(response: Response) {
    val error = gson.fromJson<Error>(response.body?.string(), Error::class.java) as Error
    throw ApiException("Error (code: ${response.code}, message: ${error.error}", response.code)
  }

  private fun setRateLimit(response: Response) {
    val rateLimitLimit = response.headers["X-Rate-Limit-Limit"]!!.toInt()
    val rateLimitRemaining = response.headers["X-Rate-Limit-Remaining"]!!.toInt()
    val rateLimitReset = response.headers["X-Rate-Limit-Reset"]!!.toInt()
    rateLimit = RateLimit(rateLimitLimit, rateLimitRemaining, rateLimitReset)
  }

  abstract fun getIdentifierNameSingular(): String

  abstract fun getIdentifierNamePlural(): String

  abstract fun getItemType(): Type

  abstract fun getItemTypeArray(): Type

  companion object {
    const val apiUrl = "https://api.transip.nl/v6"
    val mediaTypeJson = "application/json; charset=utf-8".toMediaType()
    var rateLimit = RateLimit(-1, -1, -1)
  }
}