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
import dbLogin.AccessRights;
import dbLogin.UserCon;

/**
 * @author Gregor Ober 
 * 
 * **/

public class UserController {

	
	DBAbfragen dbCon = new DBAbfragen();
	
	public List<UserCon> getAllUser(EntityManager entityManager){
		return(List<UserCon>)dbCon.getListTable(entityManager, Konstanten.T_USER);
	}
	
	public Object getThisUser(EntityManager entityManager , String name , String pw) {
		
		try {
			String encryptedPW;
			encryptedPW = Encryption.encryptString(pw);
			
			try {
				UserCon user = (UserCon)dbCon.getUSERQUERY(entityManager, name, pw);
				 return user;
			}catch(NonUniqueResultException e ) {
				System.out.println("Mehrfach user angelegt.");
				return Konstanten.EX_S_NOUNIQUEUSER;
			}catch( NoResultException e) {
				return Konstanten.EX_S_NOUSER;
			} 
		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}
	
	public List<AccessRights> getALLAccessRights(EntityManager entityManager){
		
		return(List<AccessRights>)dbCon.getListTable(entityManager, Konstanten.T_ACCESSRIGHTS);
	}
	
	public AccessRights getReadAccessRight(EntityManager entityManager) {
		Query query = entityManager.createQuery("Select t from "+Konstanten.T_ACCESSRIGHTS+" where t."+Konstanten.C_ACCESSRIGHTS_ID+" = "+ Konstanten.I_ACCESSRIGHT_READ);
		try {
			AccessRights accessRights = (AccessRights)dbCon.selectSingleObjectFromTableByQuery(entityManager, query);
			 return accessRights;
		}catch(NonUniqueResultException e ) {
			System.out.println("Mehrfach RECHTE angelegt.");
			return null;
		}catch( NoResultException e) {
			return null;
		}
		
	}
	
	public AccessRights getWriteAccessRight(EntityManager entityManager) {
		Query query = entityManager.createQuery("Select t from "+Konstanten.T_ACCESSRIGHTS+" where t."+Konstanten.C_ACCESSRIGHTS_ID+" = "+ Konstanten.I_ACCESSRIGHT_WRITE);
		try {
			AccessRights accessRights = (AccessRights)dbCon.selectSingleObjectFromTableByQuery(entityManager, query);
			 return accessRights;
		}catch(NonUniqueResultException e ) {
			System.out.println("Mehrfach RECHTE angelegt.");
			return null;
		}catch( NoResultException e) {
			return null;
		}
		
	}
	
	public AccessRights getDeleteAccessRight(EntityManager entityManager) {
		Query query = entityManager.createQuery("Select t from "+Konstanten.T_ACCESSRIGHTS+" where t."+Konstanten.C_ACCESSRIGHTS_ID+" = "+ Konstanten.I_ACCESSRIGHT_DELETE);
		try {
			AccessRights accessRights = (AccessRights)dbCon.selectSingleObjectFromTableByQuery(entityManager, query);
			 return accessRights;
		}catch(NonUniqueResultException e ) {
			System.out.println("Mehrfach RECHTE angelegt.");
			return null;
		}catch( NoResultException e) {
			return null;
		}
		
	}
	
	public AccessRights getAdminAccessRight(EntityManager entityManager) {
		Query query = entityManager.createQuery("Select t from "+Konstanten.T_ACCESSRIGHTS+" where t."+Konstanten.C_ACCESSRIGHTS_ID+" = "+ Konstanten.I_ACCESSRIGHT_ADMIN);
		try {
			AccessRights accessRights = (AccessRights)dbCon.selectSingleObjectFromTableByQuery(entityManager, query);
			 return accessRights;
		}catch(NonUniqueResultException e ) {
			System.out.println("Mehrfach RECHTE angelegt.");
			return null;
		}catch( NoResultException e) {
			return null;
		}
		
	}
	
	
	
	
	
	public UserCon setNewUser(EntityManager entityManager , String name , String pw) {
		
		if((getThisUser(entityManager, name, pw).toString()).contentEquals(Konstanten.EX_S_NOUSER))
		{
			UserCon user = new UserCon(name, pw, Konstanten.I_MAXCHARACTER, getReadAccessRight(entityManager) );
			return user;
			
		}else{
			return null;
		}
		
	}
	
	public UserCon setNewAdminUser(EntityManager entityManager , String name , String pw) {
		
		if((getThisUser(entityManager, name, pw).toString()).contentEquals(Konstanten.EX_S_NOUSER))
		{
			UserCon user = new UserCon(name, pw, Konstanten.I_MAXCHARACTER, getAdminAccessRight(entityManager) );
			return user;
			
		}else{
			return null;
		}
		
	}
	
	
}
