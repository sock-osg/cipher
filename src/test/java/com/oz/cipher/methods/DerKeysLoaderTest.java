package com.oz.cipher.methods;

import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Created by samuel on 3/04/17.
 */
public class DerKeysLoaderTest {

  private DerKeysLoader cipherMethod;
  private static final String BASE_PATH = "keys";

  @Before
  public void init() {
    this.cipherMethod = new DerKeysLoader();
    java.security.Security.addProvider(
        new org.bouncycastle.jce.provider.BouncyCastleProvider()
    );
  }

  @Test
  public void loadPrivateKeyTest() throws Exception {
    final PrivateKey privateKey = this.cipherMethod.loadPrivateKey(BASE_PATH + "/private_key.der");
    final PublicKey publicKey = this.cipherMethod.loadPublicKey(BASE_PATH + "/public_key.der");

    System.out.println(privateKey);
    System.out.println(publicKey);
  }
}
