package Model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;


public class TestJPA {
	private static final String PERSISTENCE_UNIT_NAME = "banque";
	private static EntityManagerFactory factory;
	private static Logger logger = LogManager.getLogger(TestJPA.class);
	
	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		
		//create new client
//		em.getTransaction().begin();
//		Client client = new Client();
//		client.setLogin("wbarin");
//		client.setPassword("azerty");
//		client.setNom("Barin");
//		client.setPrenom("Willy");
//		
//		//Create compte
//		Compte compte = new Compte();
//		compte.setClient(client);
//		compte.setLibelle("compte courant");
//		List<Compte> listeComptes = new ArrayList<Compte>();
//		listeComptes.add(compte);
//		client.setLesComptes(listeComptes);
//		
//		//Create Transaction
//		Transaction transaction = new Transaction();
//		transaction.setNumero(compte);
//		transaction.setLibelle("debit");
//		transaction.setMontant(10);
//		em.persist(client);
//		em.persist(compte);
//		em.persist(transaction);
//		em.getTransaction().commit();
		
		//read the existing entries and write console
		TypedQuery<Client> tQuery = em.createQuery("from Client", Client.class);
		List<Client> clientList = tQuery.getResultList();
		PersistenceUtil util = Persistence.getPersistenceUtil();
		for(Client c : clientList) {
			logger.info(c.toString());
			logger.debug("is client loaded ? " + util.isLoaded(c));
			logger.debug("is compte loaded ? " +util.isLoaded(c.getLesComptes()));
			Compte co = c.getLesComptes().get(0);
			logger.debug("premier compte chargé ? " + util.isLoaded(co));
			logger.debug("are transaction loaded ? " + util.isLoaded(co.getLesTransaction()));
			logger.debug("are trnsaction loaded now ? " + util.isLoaded(co, "transaction"));
			for(Transaction tran : co.getLesTransaction()) {
				logger.info(tran.toString());
			}
			
		}
		
		System.out.println("Size: " + clientList.size());
		em.close();
	}
}
