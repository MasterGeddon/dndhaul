package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import konsti.Konstanten;

/**
 * @author Gregor Ober 
 * 
 * **/
public class DBAbfragen {

	
	
	// gibt die elemente des angegebenen tabels zurück
	public Object getListTable(EntityManager entityManager , String table ) {
	
		
		 Query query = entityManager.
			      createQuery( "Select t " +
			      "from "+table+" t");
			      List<Object> list=(List<Object>)query.getResultList( );
		
		
		return list;
	}
	
	// löscht ein element aus der angegebenen Tabelle anhand seines Inhalts , im zugehörigen Column feld
	public void deleteObjectFromTable(EntityManager entityManager , String table, int id , String idFeld) {
		
		 Query query = entityManager.
			      createQuery( "Delete" +
			      "from "+table+" t"+
			    	"where t."+idFeld+" ="	+id  );
	}
	
	// gibt ein element aus der angegebenen Tabelle anhand seines Inhalts , im zugehörigen Column feld zurück
		public Object selectObjectFromTable(EntityManager entityManager , String table, int id , String idFeld) {
			
			 Query query = entityManager.
				      createQuery( "Select t " +
				      " from "+table+" t "+
				    	"where t."+idFeld+" ="	+id  );
			 
			 List<Object> list = (List<Object>)query.getResultList();
			 return list;
		}
	
		public Object selectObjectFromTableByQuery(EntityManager entityManager ,Query query) {
			
			 List<Object> list = (List<Object>)query.getResultList();
			 return list;
		}
		
		public Object selectSingleObjectFromTableByQuery(EntityManager entityManager ,Query query) {
			
				Object list = (Object)query.getSingleResult();
			 return list;
		}
		
		public Object getUSERQUERY(EntityManager entityManager , String name , String encryptedPW) {
			System.out.println("PASSW :"+encryptedPW);
			 Query query = entityManager.
				      createQuery( "SELECT t " +
				      " FROM "+Konstanten.T_USER+" t "+
				    	"WHERE t."+Konstanten.C_USER_NAME+" = "+"\'"+name+"\'"+
				    	" AND " +"t."+Konstanten.C_USER_PASSWORD+" = "+"\'"+encryptedPW+"\'");
			return  selectSingleObjectFromTableByQuery(entityManager, query);
			 
		}
		
}
