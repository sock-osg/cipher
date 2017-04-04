package com.oz.cipher.methods;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Created by samuel on 4/04/17.
 */
public class JavaKeysLoader implements KeysLoader {

  private static final ClassLoader CLASS_LOADER = JavaKeysLoader.class.getClassLoader();

  @Override
  public PrivateKey loadPrivateKey(String filePath) throws Exception {
    InputStream in = CLASS_LOADER.getResourceAsStream(filePath);
    byte[] keyBytes = new byte[in.available()];
    in.read(keyBytes);
    in.close();

    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(keyBytes));
    KeyFactory kf = KeyFactory.getInstance("RSA", "SunRsaSign");
    return kf.generatePrivate(spec);
  }

  @Override
  public PublicKey loadPublicKey(String filePath) throws Exception {
    InputStream in = CLASS_LOADER.getResourceAsStream(filePath);
    byte[] keyBytes = new byte[in.available()];
    in.read(keyBytes);
    in.close();

    X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.getDecoder().decode(keyBytes));
    KeyFactory kf = KeyFactory.getInstance("RSA", "SunRsaSign");
    return kf.generatePublic(spec);
  }
}
