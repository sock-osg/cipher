package com.oz.cipher.methods;

import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Created by samuel on 3/04/17.
 */
public class PemKeysLoaderTest {

  private PemKeysLoader cipherMethod;
  private static final String BASE_PATH = "keys";

  @Before
  public void init() {
    this.cipherMethod = new PemKeysLoader();
  }

  @Test
  public void loadPrivateKeyTest() throws Exception {
    final PrivateKey privateKey = this.cipherMethod.loadPrivateKey(BASE_PATH + "/private_key.pem");
    final PublicKey publicKey = this.cipherMethod.loadPublicKey(BASE_PATH + "/public_key.pem");

    System.out.println(privateKey);
    System.out.println(publicKey);
  }
}
