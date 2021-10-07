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
import javax.persistence.TypedQuery;

import model.ListDetails;

public class ListDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebEmployeeList");
	
	public void insertNewListDetails(ListDetails s)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListDetails> getLists()
	{
		EntityManager em = emfactory.createEntityManager();
		List<ListDetails> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
		return allDetails;
	}
	
	public void deleteList(ListDetails toDelete)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListDetails> typedQuery = em.createQuery("select detail from ListDetails detail where detail.id= :selectedId", ListDetails.class);
		
		//sub parameter with actual data from the toDelte item
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		// only 1 result
		typedQuery.setMaxResults(1);
		
		// get result and save into a new list item
		ListDetails result = typedQuery.getSingleResult();
		
		//Remove result
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public ListDetails searchForListDetailsById(Integer tempId)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListDetails found = em.find(ListDetails.class, tempId);
		em.close();
		return found;
	}
	
}
