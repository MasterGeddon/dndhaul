package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import db.UserCon;
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
		
}
