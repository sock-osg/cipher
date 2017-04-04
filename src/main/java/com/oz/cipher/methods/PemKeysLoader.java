package com.oz.cipher.methods;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Created by samuel on 3/04/17.
 */
public class PemKeysLoader implements KeysLoader {

  private static final ClassLoader CLASS_LOADER = PemKeysLoader.class.getClassLoader();

  public PemKeysLoader() {
    java.security.Security.addProvider(
        new org.bouncycastle.jce.provider.BouncyCastleProvider()
    );
  }

  @Override
  public PrivateKey loadPrivateKey(String filePath) throws Exception {
    InputStream in = CLASS_LOADER.getResourceAsStream(filePath);
    byte[] keyBytes = new byte[in.available()];
    in.read(keyBytes);
    in.close();

    String privKey = new String(keyBytes, "UTF-8");
    privKey = privKey.replaceAll("(-+BEGIN RSA PRIVATE KEY-+\\r?\\n|-+END RSA PRIVATE KEY-+\\r?\\n?|\\n)", "");

    keyBytes = Base64.getDecoder().decode(privKey);

    // generate public key
    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    return keyFactory.generatePrivate(spec);
  }

  @Override
  public PublicKey loadPublicKey(String filePath) throws Exception {
    InputStream in = CLASS_LOADER.getResourceAsStream(filePath);
    byte[] keyBytes = new byte[in.available()];
    in.read(keyBytes);
    in.close();

    String pubKey = new String(keyBytes, "UTF-8");
    pubKey = pubKey.replaceAll("(-+BEGIN PUBLIC KEY-+\\r?\\n|-+END PUBLIC KEY-+\\r?\\n?|\\n)", "");

    keyBytes = Base64.getDecoder().decode(pubKey);

    // generate public key
    X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    return keyFactory.generatePublic(spec);
  }
}
