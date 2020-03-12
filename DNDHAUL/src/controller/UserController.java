package controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import konsti.Konstanten;
import db.AccessRights;
import db.UserCon;

/**
 * @author Gregor Ober 
 * 
 * **/

public class UserController {

	
	DBAbfragen dbCon = new DBAbfragen();
	
	
	//gibt alle User zurück
	public List<UserCon> getAllUser(EntityManager entityManager){
		return(List<UserCon>)dbCon.getListTable(entityManager, Konstanten.T_USER);
	}
	
	//holt den user mit dem Passwort da der Name Unique ist ist es kein problem
	public Object getUSERQUERY(EntityManager entityManager , String name , String encryptedPW) {
		
		List<UserCon> cons=getAllUser(entityManager);
		
		for(UserCon uc: cons) {
			if(uc.getUserName().contentEquals(name)) {
				System.out.println(uc.getUserPassword());
				System.out.println(encryptedPW);
				if(uc.getUserPassword().contentEquals(encryptedPW)) {
					return uc;
				}
				else {
					return null;
				}
			}
		}
		return null;
		
	}
	
	// gibt einem einen User zurück anhand seines Passworts
	public Object getThisUser(EntityManager entityManager , String name , String pw) {
		
		try {
			String encryptedPW;
			encryptedPW = Encryption.firstencryptString(pw);
			UserCon user = (UserCon)getUSERQUERY(entityManager, name, encryptedPW);
			 return user;
		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}
	
	// gibt einem alle Rechte zurück.
	public List<AccessRights> getALLAccessRights(EntityManager entityManager){
		
		return(List<AccessRights>)dbCon.getListTable(entityManager, Konstanten.T_ACCESSRIGHTS);
	}
	
	// 
	// gibt einem das Lese recht zurück
	public AccessRights getReadAccessRight(EntityManager entityManager) {
//		Query query = entityManager.createQuery("Select t from "+Konstanten.T_ACCESSRIGHTS+" t where t."+Konstanten.C_ACCESSRIGHTS_ID+" = "+ Konstanten.I_ACCESSRIGHT_READ);
			AccessRights accessRights = entityManager.find(AccessRights.class, Konstanten.I_ACCESSRIGHT_READ);
			return accessRights;
		
	}
	
	// gibt einem das Schreib recht zurück
	public AccessRights getWriteAccessRight(EntityManager entityManager) {
//		Query query = entityManager.createQuery("Select t from "+Konstanten.T_ACCESSRIGHTS+" t where t."+Konstanten.C_ACCESSRIGHTS_ID+" = "+ Konstanten.I_ACCESSRIGHT_WRITE);
		
			AccessRights accessRights = entityManager.find(AccessRights.class, Konstanten.I_ACCESSRIGHT_WRITE);
			 return accessRights;
		
		
	}
	// gibt einem das Lösch recht zurück
	public AccessRights getDeleteAccessRight(EntityManager entityManager) {
//		Query query = entityManager.createQuery("Select t from "+Konstanten.T_ACCESSRIGHTS+" t where t."+Konstanten.C_ACCESSRIGHTS_ID+" = "+ Konstanten.I_ACCESSRIGHT_DELETE);
	
			AccessRights accessRights = entityManager.find(AccessRights.class, Konstanten.I_ACCESSRIGHT_DELETE);
			return accessRights;
	
		
	}
	
	// gibt einem dass Admin recht zurück
	public AccessRights getAdminAccessRight(EntityManager entityManager) {
//		Query query = entityManager.createQuery("Select t from "+Konstanten.T_ACCESSRIGHTS+" t where t."+Konstanten.C_ACCESSRIGHTS_ID+" = "+ Konstanten.I_ACCESSRIGHT_ADMIN);
	
			AccessRights accessRights = entityManager.find(AccessRights.class, Konstanten.I_ACCESSRIGHT_ADMIN);//(AccessRights)dbCon.selectSingleObjectFromTableByQuery(entityManager, Konstanten.T_ACCESSRIGHTS,Konstanten.C_ACCESSRIGHTS_ID,Konstanten.I_ACCESSRIGHT_ADMIN);
			 return accessRights;
		
	}
	
	
	
	
	// Erstellt einen neune User mit lese rechten
	public UserCon setNewUserRead(EntityManager entityManager , String name , String pw) {
		
		if((getThisUser(entityManager, name, pw).toString()).contentEquals(Konstanten.EX_S_NOUSER))
		{
			UserCon user = new UserCon(name, pw, Konstanten.I_MAXCHARACTER, getReadAccessRight(entityManager) );
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.flush();
			entityManager.getTransaction().commit();
			return user;
			
		}else{
			return null;
		}
		
	}
	
	
	// erstellt einen neuen AdminUser
	public UserCon setNewAdminUser(EntityManager entityManager , String name , String pw) {
		
		if(getThisUser(entityManager, name, pw)==null)
		{
			UserCon user = new UserCon(name, pw, Konstanten.I_MAXCHARACTER, getAdminAccessRight(entityManager) );
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.flush();
			entityManager.getTransaction().commit();
			return user;
			
		}else{
			return null;
		}
		
	}
	// erstellt einen neunen User mit bestimmten Rechten.
	public UserCon setNewUser(EntityManager entityManager , String name, String pw ,AccessRights access) {
		if(getThisUser(entityManager, name, pw)==null)
		{
			UserCon user = new UserCon(name, pw, Konstanten.I_MAXCHARACTER, access );
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.flush();
			entityManager.getTransaction().commit();
			return user;
			
		}else{
			return null;
		}
	}
	
}
