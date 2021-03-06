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
	
	
	private static String privateKey ="K87)sadf?sx,_462as�xc";
	
	
	//https://www.torsten-horn.de/techdocs/ascii.htm
	//https://howtodoinjava.com/regex/java-clean-ascii-text-non-printable-chars/
	//https://stackoverflow.com/questions/6684665/java-byte-array-to-string-to-byte-array
	//https://stackoverflow.com/questions/8519669/replace-non-ascii-character-from-string#8519863
	//https://stackoverflow.com/questions/13175129/split-and-error
	
	
	// bei diesen zeichen kam es zu problemen . dadurch werden sie entfernt
	public static String filterString( String string) {
		
		// [
		string = string.replaceAll("\\x5b", "");
		// ]
		string = string.replaceAll("\\x5d", "");
		// \
		string = string.replaceAll("\\x5c", "");
		// /
		string = string.replaceAll("\\x7c", "");
		// {
		string = string.replaceAll("\\x7b", "");
		// }
		string = string.replaceAll("\\x7d", "");
		// )
		string = string.replaceAll("\\x28", "");
		// (
		string = string.replaceAll("\\x29", "");
		// |
		string = string.replaceAll("\\x7c", "");
		
		
		return string;
	}
	
	
	// Verschl�sselt den String
	public static String firstencryptString(String text) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		byte[] newKey = (privateKey).getBytes("UTF-8");
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
		newKey = sha.digest(newKey);
		SecretKeySpec secretKey = new SecretKeySpec(newKey,"AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[]encrypt = cipher.doFinal(text.getBytes());
		String pw = new String(Base64.getEncoder().encode(encrypt));
		
		return filterString(pw);
	}
	
	


}
