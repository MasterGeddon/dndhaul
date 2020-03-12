package controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;

//http://blog.axxg.de/java-aes-verschluesselung-mit-beispiel/
//https://stackoverflow.com/questions/13109588/encoding-as-base64-in-java

/**
 * @author Gregor Ober 
 * 
 * **/
public class Encryption {
	
	
	private static String privateKey ="K87)sadf?sx,_462asüxc";
	
	
	public static String encryptString(String text) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		byte[] newKey = (privateKey).getBytes("UTF-8");
		MessageDigest sha = MessageDigest.getInstance("SHA-512");
		newKey = sha.digest(newKey);
		SecretKeySpec secretKey = new SecretKeySpec(newKey,"AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[]encrypt = cipher.doFinal(text.getBytes());
		
		return ""+Base64.getEncoder().encode(encrypt);
	}
	

}
