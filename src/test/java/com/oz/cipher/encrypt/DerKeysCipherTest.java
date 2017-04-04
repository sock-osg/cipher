package com.oz.cipher.encrypt;

import org.junit.Before;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/**
 * Created by samuel on 4/04/17.
 */
public class DerKeysCipherTest {

  private DerKeysCipher derCipher;

  @Before
  public void init() throws Exception {
    this.derCipher = new DerKeysCipher();
  }

  @Test
  public void encryptInBase64Test() throws BadPaddingException, IllegalBlockSizeException {
    String originalMessage = "Hello fucking world!!";
    System.out.printf("Original message: %s\n", originalMessage);

    String encryptedMessage = this.derCipher.encryptInBase64(originalMessage);
    System.out.printf("Encrypted message: %s\n", encryptedMessage);

    String decryptedMessage = this.derCipher.decryptFromBase64(encryptedMessage);
    System.out.printf("Decrypted message: %s\n", decryptedMessage);
  }
}
