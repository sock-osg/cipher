package com.oz.cipher.encrypt;

import com.oz.cipher.methods.JavaKeysLoader;

/**
 * Created by samuel on 4/04/17.
 */
public class JavaKeysCipher extends AbstractCipher {

  public JavaKeysCipher() throws Exception {
    super(new JavaKeysLoader(),"keys/private_key_java", "keys/public_key_java");
  }
}
