package com.oz.cipher.encrypt;

import com.oz.cipher.methods.PemKeysLoader;

import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by samuel on 4/04/17.
 */
public class PemKeysCipher extends AbstractCipher {

  public PemKeysCipher() throws Exception {
    super(new PemKeysLoader(),"keys/private_key.pem", "keys/public_key.pem");
  }
}
