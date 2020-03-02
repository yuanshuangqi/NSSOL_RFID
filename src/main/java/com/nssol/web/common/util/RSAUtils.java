package com.nssol.web.common.util;

import cn.hutool.core.io.FileUtil;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAUtils {
    private static final int DEFAUYT_SIZE = 2048;

    /**
     * 获取公钥
     * @param bytes
     * @return
     * @throws Exception
     */
    private static PublicKey getPublicKey(byte[] bytes) throws Exception{
        bytes = Base64.getDecoder().decode(bytes);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePublic(spec);

    }
    /**
     * 获取公钥
     * @param bytes
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(String path) throws Exception{
        return getPublicKey(  FileUtil.readBytes(path));
    }
    /**
     * 获取私钥
     * @param bytes
     * @return
     * @throws Exception
     */
    private static PrivateKey getPrivateKey(byte[] bytes) throws Exception{
        bytes = Base64.getDecoder().decode(bytes);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePrivate(spec);

    }
    /**
     * 获取私钥
     * @param bytes
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String path) throws Exception{
        return getPrivateKey(FileUtil.readBytes(path));

    }

    public static void generateKey(String publicKeyFilename,String privateKeyFilename,String secret,int keySize)throws Exception{
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(secret.getBytes());
        keyPairGenerator.initialize(Math.max(keySize,DEFAUYT_SIZE),secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        //获取公钥
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        publicKeyBytes = Base64.getEncoder().encode(publicKeyBytes);
        FileUtil.writeBytes(publicKeyBytes,publicKeyFilename);
        //获取私钥并写出
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        privateKeyBytes = Base64.getEncoder().encode(privateKeyBytes);
        FileUtil.writeBytes(privateKeyBytes,privateKeyFilename);
    }

}
