/**
 * 
 */
package com.junaid.api.builder.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author juansari
 *
 */
@Component
public class PasswordUtil {
	private static Logger logger = LoggerFactory.getLogger(PasswordUtil.class);
	private static String ALGO="Blowfish";

	public static String encrypt(String input, String key) throws Exception {
        byte[] keyData = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, ALGO);
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] hasil = cipher.doFinal(input.getBytes());        
        return Base64.getEncoder().encodeToString(hasil);
    }
     
	public static String decrypt(String input, String key) throws Exception {
        byte[] keyData = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, ALGO);
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);        
        byte[] hasil = cipher.doFinal(Base64.getDecoder().decode(input));
        return new String(hasil);
    }
	public static String encrypt(String input){
		String encPass = null;
		try {
			encPass= encrypt(input,Constants.ENC_KEY);
		} catch (Exception e) {
			logger.error("Error in encryption", e);
		}
		return encPass;
	}
     
	public static String decrypt(String input) {
		String decPass=null;
		try {
			decPass= decrypt(input,Constants.ENC_KEY);
		} catch (Exception e) {
			logger.error("Error in decryption", e);
		}
		return decPass;
	}
}
