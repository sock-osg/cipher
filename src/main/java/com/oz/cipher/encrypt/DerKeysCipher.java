package com.oz.cipher.encrypt;

import com.oz.cipher.methods.DerKeysLoader;

/**
 * Created by samuel on 4/04/17.
 */
public class DerKeysCipher extends AbstractCipher {

  public DerKeysCipher() throws Exception {
    super(new DerKeysLoader(), "keys/private_key.der", "keys/public_key.der");
  }
}
