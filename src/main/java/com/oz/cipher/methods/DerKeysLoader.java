package com.oz.cipher.methods;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by samuel on 3/04/17.
 */
public class DerKeysLoader implements KeysLoader {

  private static final ClassLoader CLASS_LOADER = DerKeysLoader.class.getClassLoader();

  @Override
  public PrivateKey loadPrivateKey(String filePath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
    InputStream in = CLASS_LOADER.getResourceAsStream(filePath);
    byte[] keyBytes = new byte[in.available()];
    in.read(keyBytes);
    in.close();

    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory kf = KeyFactory.getInstance("RSA");
    return kf.generatePrivate(spec);
  }

  @Override
  public PublicKey loadPublicKey(String filePath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
    InputStream in = CLASS_LOADER.getResourceAsStream(filePath);
    byte[] keyBytes = new byte[in.available()];
    in.read(keyBytes);
    in.close();

    X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
    KeyFactory kf = KeyFactory.getInstance("RSA");
    return kf.generatePublic(spec);
  }
}
