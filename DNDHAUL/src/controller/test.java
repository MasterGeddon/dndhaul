package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import db.*;
import konsti.Konstanten;
/**
 * @author Gregor Ober 
 * 
 * **/
public class test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DBAbfragen dbf = new DBAbfragen();
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gruppe13-update");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// https://www.tutorialspoint.com/de/jpa/jpa_jpql.htm 
		
		
		List<Weapon> list  = (List<Weapon>)dbf.getListTable(entityManager, "Weapon");
			 
	      for( Weapon e:list )
	      {
	         System.out.print("Weapon ID :"+e.getWeap_id());
	         System.out.println("\t Weapon typ :"+e.getWeap_typ());
	      }
	      
	      List<Classe> list2  = (List<Classe>)dbf.selectObjectFromTable(entityManager, Konstanten.T_CLASSE , 3 , Konstanten.C_CLASSE_ID);
	      
	      
	      for( Classe e:list2 )
	      {
	         System.out.println("classe id :"+e.getClas_id());
	         List<Weapon> weaponL = new ArrayList<Weapon>();
	         weaponL.addAll(e.getWetc());
	         for(Weapon f:weaponL) {
	         System.out.println("\t Weapon typ :"+f.getWeap_typ());
	         }
	      }
//	      
	      List<UserCon> list3 =(List<UserCon>)dbf.getListTable(entityManager, Konstanten.T_USER);
	      
	      for(UserCon e :list3) {
	    	  System.out.println("USERNAME :"+e.getUserName());
	      }
	      
	      UserController userCon = new UserController();
		    
	      
	      	
		    UserCon user = (UserCon) userCon.getThisUser(entityManager, "adminUser", "admin");
//	      	UserCon user = (UserCon) userCon.setNewAdminUser(entityManager, "adminUser", "admin");
	      
		    System.out.println("UserName: "+user.getUserName());
		    System.out.println("UserPassword: "+user.getUserPassword());
		    System.out.println("UserID: "+user.getUserID());
		    System.out.println("UserMaxCharacter: "+user.getMaxCharacter());
		    

	      CharCreatorController con = new CharCreatorController();
//	      PlayerCharacter pc = con.addPlayerCharacter(entityManager, user);
//	      con.setStatsRandom(pc);
//	      con.savePlayerCharacter(entityManager, "Pressslufthammmmer da be", "Bernhard",con.getEmptyClasse(entityManager),con.getEmptyRasseSub(entityManager) ,
//	    		  pc.getChar_str() ,
//	    		  pc.getChar_dex(), 
//	    		  pc.getChar_con(),
//	    		  pc.getChar_int(), 
//	    		  pc.getChar_wis(), 
//	    		  pc.getChar_cha(), pc);
//	      
//	      con.setStatsRandom(pc);
//	      
//	      System.out.println( pc.getChar_str() +" "+
//	    		  pc.getChar_dex()+" "+
//	    		  pc.getChar_con()+" "+
//	    		  pc.getChar_int()+" "+ 
//	    		  pc.getChar_wis()+" "+
//	    		  pc.getChar_cha());
//	     pc = con.cancelEditingPC(entityManager, pc);
//	      System.out.println("canceled");
//
//	      System.out.println( pc.getChar_str() +" "+
//	    		  pc.getChar_dex()+" "+
//	    		  pc.getChar_con()+" "+
//	    		  pc.getChar_int()+" "+ 
//	    		  pc.getChar_wis()+" "+
//	    		  pc.getChar_cha());
//	      
//	      System.out.println("Dieser Character gehört :"+pc.getChar_user_id().getUserName());
//	      
//	      
//	      PlayerCharacter pc2 = con.addPlayerCharacter(entityManager, user);
//	      con.setStatsRandom(pc2);
//	      con.savePlayerCharacter(entityManager, "SuperDuper gregor", "Gregorio",con.getEmptyClasse(entityManager),con.getEmptyRasseSub(entityManager) ,
//	    		  pc2.getChar_str() ,
//	    		  pc2.getChar_dex(), 
//	    		  pc2.getChar_con(),
//	    		  pc2.getChar_int(), 
//	    		  pc2.getChar_wis(), 
//	    		  pc2.getChar_cha(), pc2);
//	      
	      
	      List<PlayerCharacter> players=con.getAllCharacterByUser(entityManager, user);
	    
	      for(PlayerCharacter pp:players) {
	    	  System.out.println("Player with id "+pp.getChar_id()+" gehört User " +pp.getChar_user_id().getUserName());
	      }
	    
		entityManager.close();
		entityManagerFactory.close();
	}

	
}
