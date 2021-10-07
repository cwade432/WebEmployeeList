/**
 * @author Caleb - cawasle
CIS175 - Fall 2021
Oct 6, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Client;

public class ClientHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebEmployeeList");
	
	public void insertClient(Client s)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Client> showAllCLients()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Client> allClients = em.createQuery("SELECT s FROM Client s").getResultList();
		return allClients;
	}
	
}
