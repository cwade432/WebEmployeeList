/**
 * @author Caleb - cawasle
CIS175 - Fall 2021
Sep 28, 2021
 */

package controller;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Employee;
//import model.ListItem;

public class EmployeeHelper {

	public static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebEmployeeList"); // this is where error points to
	
	public void addEmployee(Employee li)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Employee> showAllEmployees()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Employee> allItems = em.createQuery("Select i from Employee i").getResultList();
		return allItems;
	}
	
	public void deleteEmployee(Employee toDelete) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employee> typedQuery = em.createQuery("select li from Employee li where li.name = :selectedName and li.address = :selectedAddress and li.position = :selectedPosition", Employee.class);
		//System.out.println("Spot1 start of deleteItem() after query search");
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedAddress", toDelete.getAddress());
		typedQuery.setParameter("selectedPosition", toDelete.getPosition());
		
		//Setting max result to 1 to get only 1 result
		typedQuery.setMaxResults(1);
		//get result and save it into a new list
		Employee result = typedQuery.getSingleResult();
		
		//Removing the single result that was returned
		em.remove(result);
		//System.out.println("Spot2 after removing before commit");
		em.getTransaction().commit(); 
		//System.out.println("Spot3 after commit");
		em.close(); 
	}
	
	public Employee searchForEmployeeById(int idToEdit)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Employee found = em.find(Employee.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateEmployee(Employee toEdit)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Employee> searchForEmployeeByName(String name)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employee> typedQuery = em.createQuery("select li from Employee li where li.name= :selectedName", Employee.class);
		typedQuery.setParameter("selectedName", name);
		List<Employee> foundName = typedQuery.getResultList();
		em.close();
		return foundName;
	}
	
	public List<Employee> searchForEmployeeByAddress(String address)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employee> typedQuery = em.createQuery("select li from Employee li where li.address= :selectedAddress", Employee.class);
		typedQuery.setParameter("selectedAddress", address);
		List<Employee> foundAddress = typedQuery.getResultList();
		em.close();
		return foundAddress;
	}
	
	public List<Employee> searchForEmployeeByPosition(String position)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employee> typedQuery = em.createQuery("select li from Employee li where li.position= :selectedPosition", Employee.class);
		typedQuery.setParameter("selectedPosition", position);
		List<Employee> foundPosition = typedQuery.getResultList();
		em.close();
		return foundPosition;
	}
		
	public void cleanUp()
	{
		emfactory.close();
	}
}

