package com.company.example.springbootdemo.util;

import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.context.annotation.Configuration;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @ClassName:AESEncryptUtil
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/5/29 11:43
 * @Version: 1.0

*/

@Log4j2
@Configuration
public class AESEncryptUtil {

    private static Key key = null;
    private static Cipher instance = null;


    public AESEncryptUtil() {
        getKey();

    }

    private static void getKey() {

        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            //使用该初始化方法每次生成的秘钥 加密后的密文每次都不固定
//          keyGenerator.init(128);
            keyGenerator.init(128, new SecureRandom("13223wrwe4345678".getBytes()));
            //使用上面这种初始化方法可以特定种子来生成密钥，这样加密后的密文是唯一固定的。
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keyEncoded = secretKey.getEncoded();
            //key 转换
            key = new SecretKeySpec(keyEncoded, "AES");
            instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException e) {
            log.error("Get KeyGenerator Failed", e);
        } catch (NoSuchPaddingException e) {
            log.error("Get KeyGenerator Failed",e);
        }
    }

    public static String encryptionStr(String encryptStr){
        String encryptionStr = "";
        try {
            instance.init(Cipher.ENCRYPT_MODE,key);
            byte[] encodeResult = instance.doFinal(encryptStr.getBytes());
            encryptionStr = HexUtils.toHexString(encodeResult);
        } catch (InvalidKeyException e) {
            log.error("Encryption Failed", e);
        } catch (BadPaddingException e) {
            log.error("Encryption Failed", e);
        } catch (IllegalBlockSizeException e) {
            log.error("Encryption Failed", e);
        }
        return encryptionStr;
    }

    public static String decrptionStr(String decrptStr) {
        String decrptionStr = "";
        try {
            instance.init(Cipher.DECRYPT_MODE,key);
            byte[] decrptResult = instance.doFinal(HexUtils.fromHexString(decrptStr));
            decrptionStr = new String(decrptResult);
        } catch (InvalidKeyException e) {
            log.error("Decryption Failed", e);
        } catch (BadPaddingException e) {
            log.error("Decryption Failed", e);
        } catch (IllegalBlockSizeException e) {
            log.error("Decryption Failed", e);
        }
        return decrptionStr;
    }

    public static void main(String[] args) {
        String a = "root1234";
        AESEncryptUtil aesEncryptUtil = new AESEncryptUtil();
        String enStr = encryptionStr(a);
        System.out.println(enStr);
        String deStr = decrptionStr(enStr);
        System.out.println(deStr);
    }
}
