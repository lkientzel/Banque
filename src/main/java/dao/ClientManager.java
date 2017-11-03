package dao;

import java.sql.*;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import Model.Client;
import Model.TestJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;

public class ClientManager {
	
	public static List<Client> loadClient(){
		EntityManagerFactory factory = dao.Factory.getInstance();
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Client> tQuery = em.createQuery("from Client", Client.class);
		List<Client> clientList = tQuery.getResultList();
		em.close();
		return clientList;
	}
	
	
	public static Client loadClientByID(int idClient) {
		EntityManagerFactory factory = dao.Factory.getInstance();
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		
		Client monClient = em.find(Client.class, idClient);
		
		em.close();
		return monClient;
	}
	
	public static Client loadClientByLogin(String login, String password) {
		EntityManagerFactory factory = dao.Factory.getInstance();
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		String requete = "select c from Client c where c.login = ?1 and password = ?2";
		Query result = em.createQuery(requete, Client.class);
		result.setParameter(1, login);
		result.setParameter(2, password);
		Client monClient = (Client) result.getSingleResult();
		em.close();
		
		return monClient;
	}
	
	public static void newClient(String nom, String prenom, String login, String password) {
		EntityManagerFactory factory = dao.Factory.getInstance();
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Client newClient = new Client();
		newClient.setNom(nom);
		newClient.setPrenom(prenom);
		newClient.setLogin(login);
		newClient.setPassword(password);
		em.persist(newClient);
		em.close();
	}
	
	public static void changePassword(String newPassword, Client client) {
		EntityManagerFactory factory = dao.Factory.getInstance();
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		client.setPassword(newPassword);
		Client monClient = em.merge(client);
		em.persist(monClient);
		em.getTransaction().commit();
		em.close();
	}
}
