package nl.wouterbohlken.transip.authentication

import com.google.gson.Gson
import nl.wouterbohlken.transip.client.Client.Companion.apiUrl
import nl.wouterbohlken.transip.client.Client.Companion.mediaTypeJson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import java.lang.Exception
import java.nio.charset.StandardCharsets
import java.util.Base64
import java.util.Random
import kotlin.collections.HashMap

class Authenticator(
  private val privateKey: File,
  private val login: String,
  private val expirationTime: String = "1 day",
  private val label: String = "",
  private val readOnly: Boolean = false,
  private val globalKey: Boolean = false
) {
  private val authUrl = "auth"

  private var httpClient = OkHttpClient()
  private val gson = Gson()

  fun generateToken(): String {
    val requestBodyMap = createRequestBody()
    val requestBodyJson = gson.toJson(requestBodyMap)
    val requestBody = requestBodyJson.toRequestBody(mediaTypeJson)

    val signature = createSignature(requestBodyJson)

    val request = Request.Builder()
      .header("Signature", signature)
      .post(requestBody)
      .url("$apiUrl/$authUrl")
      .build()

    httpClient.newCall(request).execute().use { response ->
      if (response.code == 201) {
        val responseBody = gson.fromJson<AuthenticationResponse>(response.body!!.string(), AuthenticationResponse::class.java)
        return responseBody.token
      }

      throw Exception("An error occurred: Code " + response.code + ", " + response.body!!.toString())
    }
  }

  fun createRequestBody(): Map<String, String> {
    val body = HashMap<String, String>();
    body["login"] = login
    body["nonce"] = (Random()).nextInt().toString()
    body["read_only"] = readOnly.toString()
    body["expiration_time"] = expirationTime
    body["label"] = label
    body["global_key"] = globalKey.toString()
    return body
  }

  fun createSignature(requestBodyJson: String): String {
    val signer = Signer(privateKey)
    val signature = signer.getSignature(requestBodyJson)
    val base64EncodedSignature = Base64.getEncoder().encode(signature)

    return String(base64EncodedSignature, StandardCharsets.UTF_8)
  }
}