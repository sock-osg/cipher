package com.oz.cipher.encrypt;

import org.junit.Before;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/**
 * Created by samuel on 4/04/17.
 */
public class JavaKeysCipherTest {

  private JavaKeysCipher javaKeysCipher;

  @Before
  public void init() throws Exception {
    this.javaKeysCipher = new JavaKeysCipher();
  }

  @Test
  public void encryptInBase64Test() throws Exception {
    String originalMessage = "Hello fucking world!!";
    System.out.printf("Original message: %s\n", originalMessage);

    String encryptedMessage = this.javaKeysCipher.encryptInBase64(originalMessage);
    System.out.printf("Encrypted message: %s\n", encryptedMessage);

    String decryptedMessage = this.javaKeysCipher.decryptFromBase64(encryptedMessage);
    System.out.printf("Decrypted message: %s\n", decryptedMessage);
  }
}
