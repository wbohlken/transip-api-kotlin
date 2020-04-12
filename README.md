# TransIP API Client for Kotlin/Java
A complete client implementation of the TransIP REST API for Java/Kotlin.

## Installation



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

Most product (like domain and VPS) have nested resources, for retrieving these nested resources, an additional identifier is needed, you can use the `getIdentifier()` method for this:

```kotlin
val api = TransipAPI(token)
val vpses = api.vps.vpses().list()
val firstVps = vpses[0]
val snapshots = api.vps.snapshots(firstVps.vpsIdentifier).list()
```


## Known issues and limitations

-  Only string representation of tokens: the tokens are not JSON decoded and therefore, no expiration date can be read. This issue can be fixed by using of the of the JWT libraries and decode it.
-  No pagination: some list methods on resources support pagination to keep the response size small, this is not yet implemented in this client, only full lists will be returned.
-  Child clients: every child client inherits from the Client class, this class implements all REST methods (GET, POST, PUT, PATCH, DELETE). Most resources, however, don't support all methods.
