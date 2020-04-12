package nl.wouterbohlken.transip.authentication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * A signer class for creating a SHA512 signature using a private key. Code taken from
 * https://github.com/markkolich/blog/blob/master/content/entries/howto-sha1withrsa-digital-signing-in-java-openssl-pkcs8.md
 */
public class Signer {
  private static final long MAX_KEY_SIZE_BYTES = 8192L;
  private static final String SHA_512_WITH_RSA = "SHA512withRSA";
  private static final String RSA = "RSA";

  private File pkcsKeyFile;
  private Signature signatureInstance;
  private KeyFactory keyFactory;

  public Signer(File pkcsKeyFile) {

    try {
      this.pkcsKeyFile = pkcsKeyFile;
      this.signatureInstance = Signature.getInstance(SHA_512_WITH_RSA);
      this.keyFactory = KeyFactory.getInstance(RSA);

      this.init();
    } catch (Exception e) {
      // Wrap it, so every where that you use PKCS8RSASigner
      // you don't have to wrap the constructor in a try/catch.
      // But the caller should catch Error's though.
      throw new Error(e);
    }
  }

  /**
   * Given a message, generate a signature based on this PKCS#8 private key.
   *
   * @throws Exception
   */
  public byte[] getSignature(String message) throws Exception {
    byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
    this.signatureInstance.update(bytes);
    return this.signatureInstance.sign();
  }

  /**
   * Setup this PKCS8RSASigner. Load the key file into memory, and init the key factory accordingly.
   *
   * @throws IOException
   */
  private void init() throws Exception {
    FileInputStream is = null;

    if (!this.pkcsKeyFile.exists()) {
      throw new FileNotFoundException("RSA key file not found!");
    }

    // Get the size, in bytes, of the key file.
    final long length = this.pkcsKeyFile.length();

    if (length > MAX_KEY_SIZE_BYTES) {
      throw new IOException("Key file is too big!");
    }

    byte[] keyFileBytes;
    try {
      is = new FileInputStream(this.pkcsKeyFile);

      int offset = 0;
      int read = 0;
      keyFileBytes = new byte[(int) length];
      while (offset < keyFileBytes.length
          && (read = is.read(keyFileBytes, offset, keyFileBytes.length - offset)) >= 0) {
        offset += read;
      }

    } finally {
      try {
        if (is != null) {
          is.close();
        }
      } catch (IOException ioe) {
        throw new Exception("Error, couldn't close FileInputStream", ioe);
      }
    }

    PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(keyFileBytes);

    // Get the private key from the key factory.
    PrivateKey privateKey = keyFactory.generatePrivate(privKeySpec);

    // Init the signature from the private key.
    this.signatureInstance.initSign(privateKey);
  }
}
