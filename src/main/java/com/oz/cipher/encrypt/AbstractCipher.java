package com.oz.cipher.encrypt;

import com.oz.cipher.methods.KeysLoader;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.util.Base64;

/**
 * Created by samuel on 4/04/17.
 */
public abstract class AbstractCipher {

  private KeysLoader keysLoader;
  private Cipher encryptCipher;
  private Cipher decryptCipher;

  protected AbstractCipher(KeysLoader keysLoader, String privateKeyPath, String publicKeyPath) throws Exception {
    this.keysLoader = keysLoader;

    this.encryptCipher = Cipher.getInstance("RSA");
    this.encryptCipher.init(Cipher.ENCRYPT_MODE, this.keysLoader.loadPrivateKey(privateKeyPath));

    this.decryptCipher = Cipher.getInstance("RSA");
    this.decryptCipher.init(Cipher.DECRYPT_MODE, this.keysLoader.loadPublicKey(publicKeyPath));
  }

  public String encryptInBase64(String message) throws BadPaddingException, IllegalBlockSizeException {
    return this.toBase64(this.encryptCipher.doFinal(message.getBytes()));
  }

  public String decryptFromBase64(String messageInBase64) throws BadPaddingException, IllegalBlockSizeException {
    return new String(this.decryptCipher.doFinal(Base64.getDecoder().decode(messageInBase64.getBytes())));
  }

  private String toBase64(byte[] encryptedMessage) {
    return Base64.getEncoder().encodeToString(encryptedMessage);
  }
}
