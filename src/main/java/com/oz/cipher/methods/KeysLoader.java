package com.oz.cipher.methods;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Created by samuel on 4/04/17.
 */
public interface KeysLoader {

  PrivateKey loadPrivateKey(String filePath) throws Exception;

  PublicKey loadPublicKey(String filePath) throws Exception;
}
