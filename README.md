# TransIP API Client for Kotlin/Java
A complete client implementation of the TransIP REST API for Java/Kotlin.

See the complete documentation [here](https://api.transip.nl/rest/docs.html)

You can use the following demo token to try it out:
```
eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImN3MiFSbDU2eDNoUnkjelM4YmdOIn0.eyJpc3MiOiJhcGkudHJhbnNpcC5ubCIsImF1ZCI6ImFwaS50cmFuc2lwLm5sIiwianRpIjoiY3cyIVJsNTZ4M2hSeSN6UzhiZ04iLCJpYXQiOjE1ODIyMDE1NTAsIm5iZiI6MTU4MjIwMTU1MCwiZXhwIjoyMTE4NzQ1NTUwLCJjaWQiOiI2MDQ0OSIsInJvIjpmYWxzZSwiZ2siOmZhbHNlLCJrdiI6dHJ1ZX0.fYBWV4O5WPXxGuWG-vcrFWqmRHBm9yp0PHiYh_oAWxWxCaZX2Rf6WJfc13AxEeZ67-lY0TA2kSaOCp0PggBb_MGj73t4cH8gdwDJzANVxkiPL1Saqiw2NgZ3IHASJnisUWNnZp8HnrhLLe5ficvb1D9WOUOItmFC2ZgfGObNhlL2y-AMNLT4X7oNgrNTGm-mespo0jD_qH9dK5_evSzS3K8o03gu6p19jxfsnIh8TIVRvNdluYC2wo4qDl5EW5BEZ8OSuJ121ncOT1oRpzXB0cVZ9e5_UVAEr9X3f26_Eomg52-PjrgcRJ_jPIUYbrlo06KjjX2h0fzMr21ZE023Gw
```

## Installation

See the repository and versions on [maven central](https://search.maven.org/artifact/nl.wouterbohlken.transip-api-kotlin/transip-api-client)

### Gradle DSL
```
implementation 'nl.wouterbohlken.transip-api-kotlin:transip-api-client:1.0.0'
```

### Apache maven
```xml
<dependency>
  <groupId>nl.wouterbohlken.transip-api-kotlin</groupId>
  <artifactId>transip-api-client</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Authentication

1.  Request key in control panel, save its contents to a `key.pem` file in your preferred directory.

2.  To make use of the API, the key needs to be converted to PKCS8 format, run the following command and save the `key.pkcs8` file:

```bash
openssl pkcs8 -topk8 -in key.pem -nocrypt -outform DER -out key.pkcs8
```

3.  Now that we have a key, we can generate tokens like such:

```kotlin
import nl.wouterbohlken.transip.api.TransipAPI
import nl.wouterbohlken.transip.authentication.Authenticator
import java.io.File

val privateKey = File("/path/to/key.pkcs8")
val login = "your-username"
val authenticator = Authenticator(privateKey, login)
val token = authenticator.generateToken()
```

You can add parameters to the Authenticator to set an expiration date, label, etc.


## Examples

Every API should make use of the TransipAPI class. This class only requires a token and then passes this to all resources.

A typical API call looks like this:

```kotlin
val api = TransipAPI(token)
val vpses = api.vps.vpses().list()
```

Most functionality have been covered by specific methods, for instance, to register a domain, you can use the following call:

```kotlin
val api = TransipAPI(token)
api.domain.domains().register("tranip-api-test.nl")
```

For a complete set of API call examples, please refer to the `library/src/main/kotlin/nl/wouterbohlken/transip/examples` directory in this repository.

Most products (like domain and VPS) have nested resources, for retrieving these nested resources, an additional identifier is needed, you can use the `getIdentifier()` method for this:

```kotlin
val api = TransipAPI(token)
val vpses = api.vps.vpses().list()
val firstVps = vpses[0]
val snapshots = api.vps.snapshots(firstVps.getIdentifier()).list()
```


## Limitations

-  Only string representation of tokens: the tokens are not JSON decoded and therefore, no expiration date can be read. This issue can be fixed by using one of the JWT libraries and decode it.
-  No pagination: some list methods on resources support pagination to keep the response size small, this is not yet implemented in this client, only full lists will be returned.
-  Child clients: every child client inherits from the Client class, this class implements all REST methods (GET, POST, PUT, PATCH, DELETE). Most resources, however, don't support all methods. Please refer to the documentation to see what methods can be used on the resources.
-  Only supports pkcs8 format keys, not the original generated in the control panel.