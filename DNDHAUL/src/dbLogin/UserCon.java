package dbLogin;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import controller.Encryption;
import konsti.Konstanten;
/**
 * @author Gregor Ober 
 * 
 * **/

@Entity
@Table(name = Konstanten.T_USER)
public class UserCon implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = Konstanten.C_USER_ID)
	private int userID;
	
	@Column(name = Konstanten.C_USER_NAME ,unique = true, nullable = false)
	private String userName;
	
	@Column(name = Konstanten.C_USER_PASSWORD , nullable = false)
	private String userPassword;
	
	
	@Column(name = Konstanten.C_USER_MAXCHARACTER , nullable = false)
	private int maxCharacter;
	
	@ManyToOne
	@JoinColumn(name = Konstanten.C_USER_ACCESSRIGHTS , nullable = false)
	private AccessRights userRights;

	
	public UserCon(String userName, String userPW, int maxCharacter , AccessRights userRights) {
		this.userName = userName;
		try {
			this.setUserPassword(userPW);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.maxCharacter = maxCharacter;
		this.userRights = userRights;
	}
	
	
	public int getUserID() {
		return userID;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		this.userPassword = Encryption.encryptString(userPassword);
	}

	public int getMaxCharacter() {
		return maxCharacter;
	}

	public void setMaxCharacter(int maxCharacter) {
		this.maxCharacter = maxCharacter;
	}

	public AccessRights getUserRights() {
		return userRights;
	}

	public void setUserRights(AccessRights userRights) {
		this.userRights = userRights;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
