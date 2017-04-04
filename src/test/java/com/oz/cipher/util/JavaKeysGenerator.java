package com.oz.cipher.util;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 * <p><b>Created:</b> 28/03/17, 10:25 AM</p>
 *
 * @since 1.0
 */
public class JavaKeysGenerator {

  private KeyPairGenerator keyGen;
  private KeyPair pair;
  private PrivateKey privateKey;
  private PublicKey publicKey;

  public void init(int keylength) throws NoSuchAlgorithmException, NoSuchProviderException {
    this.keyGen = KeyPairGenerator.getInstance("RSA", "SunRsaSign");
    this.keyGen.initialize(keylength);
  }

  public void createKeys() {
    this.pair = this.keyGen.generateKeyPair();
    this.privateKey = pair.getPrivate();
    this.publicKey = pair.getPublic();
  }

  public PrivateKey getPrivateKey() {
    return this.privateKey;
  }

  public PublicKey getPublicKey() {
    return this.publicKey;
  }

  public void writeToFile(String path, byte[] key) throws IOException, URISyntaxException {
    File f = new File(Paths.get("src/test/resources").toAbsolutePath().toFile(), path);
    f.getParentFile().mkdirs();

    FileOutputStream fos = new FileOutputStream(f);
    fos.write(key);
    fos.flush();
    fos.close();
  }

  @Test
  public void generateKeys() throws URISyntaxException, NoSuchProviderException, NoSuchAlgorithmException, IOException {
    this.init(2048);
    this.createKeys();
    this.writeToFile("keys/private_key_java", Base64.getEncoder().encode(this.getPrivateKey().getEncoded()));
    this.writeToFile("keys/public_key_java", Base64.getEncoder().encode(this.getPublicKey().getEncoded()));
  }
}
