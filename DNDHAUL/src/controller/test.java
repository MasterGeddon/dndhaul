package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import db.*;
import konsti.Konstanten;

public class test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DBAbfragen dbf = new DBAbfragen();
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gruppe13-update");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// https://www.tutorialspoint.com/de/jpa/jpa_jpql.htm 
		
		
//		List<Weapon> list  = (List<Weapon>)dbf.getListTable(entityManager, "Weapon");
//			 
//	      for( Weapon e:list )
//	      {
//	         System.out.print("Weapon ID :"+e.getWeap_id());
//	         System.out.println("\t Weapon typ :"+e.getWeap_typ());
//	      }
	      
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
	      
	      CharCreatorController con = new CharCreatorController();
	      con.addPlayerCharacter(entityManager);
	      
	      
		entityManager.close();
		entityManagerFactory.close();
	}

	
}
