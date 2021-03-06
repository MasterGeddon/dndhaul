package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import db.UserCon;
import konsti.Konstanten;

/**
 * @author Gregor Ober 
 * 
 * **/
public class DBAbfragen {

	
	
	// gibt die elemente des angegebenen tabels zur�ck
	public Object getListTable(EntityManager entityManager , String table ) {
		 Query query = entityManager.
			      createQuery( "Select t " +
			      "from "+table+" t");
			      List<Object> list=(List<Object>)query.getResultList( );	
		return list;
	}
	
	// l�scht ein element aus der angegebenen Tabelle anhand seines Inhalts , im zugeh�rigen Column feld
	public void deleteObjectFromTable(EntityManager entityManager , String table, int id , String idFeld) {
		
		  int count = entityManager.
			      createQuery( "Delete " +
			      "from "+table+" t "+
			    	"where t."+idFeld+" ="	+id  ).executeUpdate();
		 
		 
	}
	
	// gibt ein element aus der angegebenen Tabelle anhand seines Inhalts , im zugeh�rigen Column feld zur�ck
		public Object selectObjectFromTable(EntityManager entityManager , String table, int id , String idFeld) {
			
			 Query query = entityManager.
				      createQuery( "Select t " +
				      " from "+table+" t "+
				    	"where t."+idFeld+" ="	+id  );
			 
			 List<Object> list = (List<Object>)query.getResultList();
			 return list;
		}

		//funktioniert nicht
//		public Object selectObjectFromTableByQuery(EntityManager entityManager ,Query query) {
//			
//			 List<Object> list = (List<Object>)query.getResultList();
//			 return list;
//		}
		
		
		//funktioniert nicht
//		public Object selectSingleObjectFromTableByQuery(EntityManager entityManager ,String table , String idFeld,int id) {
//			 Query query = entityManager.
//				      createQuery( "Select t " +
//				      " from "+table+" t "+
//				    	"where t."+idFeld+" ="	+id  );
//				Object list = (Object)query.getSingleResult();
//			 return list;
//		}
//		
		
		public void startEntityManager(EntityManagerFactory entityManagerFactory) {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			
			StaticClassObjects.entityManager = entityManager;
		}
		
		public void startEntityManagerFactory() {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gruppe13-update");
			StaticClassObjects.entiyMangerFactory =entityManagerFactory;
		}
		
		public void closeEntityManager(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
			
			entityManager.close();
			entityManagerFactory.close();
			
			
		}
		
		public void startUp() {
			startEntityManagerFactory();
			startEntityManager(StaticClassObjects.entiyMangerFactory);
		}
		
		
}
