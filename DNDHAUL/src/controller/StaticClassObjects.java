package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import db.UserCon;

public class StaticClassObjects {
	
	
	public static UserCon currentUser;
	public static EntityManager entityManager;
	public static EntityManagerFactory entiyMangerFactory;

}
