package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {
	
	private static EntityManagerFactory factory;
	private static final String PERSISTENCE_UNIT_NAME = "banque";
	
	private Factory() {
		
	}
	
	
	public static EntityManagerFactory getInstance() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		
		return factory;
	}
}
