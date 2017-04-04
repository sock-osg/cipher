package com.oz.cipher.methods;

import sun.misc.BASE64Decoder;

import java.io.FileInputStream;
import java.io.IOException;
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
public class PemFilesWithBouncyCastle {

  public PemFilesWithBouncyCastle() {
    java.security.Security.addProvider(
        new org.bouncycastle.jce.provider.BouncyCastleProvider()
    );
  }

  public PrivateKey loadPrivateKey(String filePath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
    FileInputStream in = new FileInputStream(filePath);
    byte[] keyBytes = new byte[in.available()];
    in.read(keyBytes);
    in.close();

    String privKey = new String(keyBytes, "UTF-8");
    privKey = privKey.replaceAll("(-+BEGIN RSA PRIVATE KEY-+\\r?\\n|-+END RSA PRIVATE KEY-+\\r?\\n?)", "");

    // don't use this for real projects!
    BASE64Decoder decoder = new BASE64Decoder();
    keyBytes = decoder.decodeBuffer(privKey);

    // generate public key
    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    return keyFactory.generatePrivate(spec);
  }

  public PublicKey loadPublicKey(String filePath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
    FileInputStream in = new FileInputStream(filePath);
    byte[] keyBytes = new byte[in.available()];
    in.read(keyBytes);
    in.close();

    String pubKey = new String(keyBytes, "UTF-8");
    pubKey = pubKey.replaceAll("(-+BEGIN PUBLIC KEY-+\\r?\\n|-+END PUBLIC KEY-+\\r?\\n?)", "");

    // don't use this for real projects!
    BASE64Decoder decoder = new BASE64Decoder();
    keyBytes = decoder.decodeBuffer(pubKey);

    // generate public key
    X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    return keyFactory.generatePublic(spec);
  }
}
