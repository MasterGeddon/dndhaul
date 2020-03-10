package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
		
		 Query query = entityManager.
			      createQuery( "Delete" +
			      "from "+table+" t"+
			    	"where t."+idFeld+" ="	+id  );
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
	
}
