package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Client;
import Model.Compte;
import Model.Transaction;

public class CompteManager {
	
	private static final String PERSISTENCE_UNIT_NAME = "banque";
	
	
	public static ArrayList<Compte> loadCompteByID(int idClient) {
		ArrayList<Compte> result = new ArrayList<Compte>();
		
		EntityManagerFactory factory = dao.Factory.getInstance();
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		
		TypedQuery<Compte> tQuery = em.createQuery("from Compte where idClient = " + idClient, Compte.class);
		List<Compte> compteList = tQuery.getResultList();
		for(Compte cpt : compteList) {
			result.add(cpt);
		}
		
		em.close();
		
		return result;
	}
	
	public static Compte loadCompteByNumero(int numero) {
		EntityManagerFactory factory = dao.Factory.getInstance();
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Compte leCompte = em.find(Compte.class, numero);
		em.close();
		return leCompte;
	}
	
	public static ArrayList<Transaction> loadTransactionByNumero(int numero){
		ArrayList<Transaction> lesTransactions = new ArrayList<Transaction>();
		
		EntityManagerFactory factory = dao.Factory.getInstance();
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Transaction> tQuery = em.createQuery("from Transaction where numero = " + numero, Transaction.class);
		List<Transaction> listTransaction = tQuery.getResultList();
		for(Transaction trans : listTransaction) {
			lesTransactions.add(trans);
		}
		
		em.close();
		
		return lesTransactions;
		
	}
	
	public static void newCompte(String libelle, Client client) {
		EntityManagerFactory factory = dao.Factory.getInstance();
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Compte newCompte = new Compte();
		newCompte.setLibelle(libelle);
		newCompte.setClient(client);
		newCompte.setSolde(0);
		
		em.persist(newCompte);
		em.close();
	}

	
}
