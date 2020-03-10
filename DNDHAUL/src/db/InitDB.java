package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * @author Gregor Ober 
 * 
 * **/
public class InitDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("schule");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		Klasse klasse = new Klasse();

//		entityManager.getTransaction().begin();

//		Schueler schnuller = new Schueler();
//		schnuller.setNachname("Beu");
//		schnuller.setVorname("Luis");
//		klasse.setKlassensprecher(schnuller);
//		schnuller.setKlassensprecherKlasse(klasse);
//		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}