package com.oz.cipher.encrypt;

import org.junit.Before;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/**
 * Created by samuel on 4/04/17.
 */
public class PemKeysCipherTest {

  private PemKeysCipher pemCipher;

  @Before
  public void init() throws Exception {
    java.security.Security.addProvider(
        new org.bouncycastle.jce.provider.BouncyCastleProvider()
    );

    this.pemCipher = new PemKeysCipher();
  }

  @Test
  public void encryptInBase64Test() throws BadPaddingException, IllegalBlockSizeException {
    String originalMessage = "Hello fucking world!!";
    System.out.printf("Original message: %s\n", originalMessage);

    String encryptedMessage = this.pemCipher.encryptInBase64(originalMessage);
    System.out.printf("Encrypted message: %s\n", encryptedMessage);

    String decryptedMessage = this.pemCipher.decryptFromBase64(encryptedMessage);
    System.out.printf("Decrypted message: %s\n", decryptedMessage);
  }
}
