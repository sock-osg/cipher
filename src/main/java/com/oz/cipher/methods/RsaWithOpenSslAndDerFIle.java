package com.oz.cipher.methods;

import java.io.DataInputStream;
import java.io.File;
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
public class RsaWithOpenSslAndDerFIle {

  public PrivateKey loadPrivateKey(String filePath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
    File f = new File(filePath);
    FileInputStream fis = new FileInputStream(f);
    DataInputStream dis = new DataInputStream(fis);
    byte[] keyBytes = new byte[(int)f.length()];
    dis.readFully(keyBytes);
    dis.close();

    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory kf = KeyFactory.getInstance("RSA");
    return kf.generatePrivate(spec);
  }

  public PublicKey loadPublicKey(String filePath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
    File f = new File(filePath);
    FileInputStream fis = new FileInputStream(f);
    DataInputStream dis = new DataInputStream(fis);
    byte[] keyBytes = new byte[(int)f.length()];
    dis.readFully(keyBytes);
    dis.close();

    X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
    KeyFactory kf = KeyFactory.getInstance("RSA");
    return kf.generatePublic(spec);
  }
}
