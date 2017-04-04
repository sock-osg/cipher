package com.oz.cipher.methods;

import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Created by samuel on 3/04/17.
 */
public class JavaKeysLoaderTest {

  private JavaKeysLoader cipherMethod;
  private static final String BASE_PATH = "keys";

  @Before
  public void init() {
    this.cipherMethod = new JavaKeysLoader();
  }

  /**
   * Test for loading keys generated with Java. Execute {@link com.oz.cipher.util.JavaKeysGenerator} in order to
   * generate the keys pair.
   * @throws Exception
   */
  @Test
  public void loadPrivateKeyTest() throws Exception {
    final PrivateKey privateKey = this.cipherMethod.loadPrivateKey(BASE_PATH + "/private_key_java");
    final PublicKey publicKey = this.cipherMethod.loadPublicKey(BASE_PATH + "/public_key_java");

    System.out.println(privateKey);
    System.out.println(publicKey);
  }
}
