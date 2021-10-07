/**
 * @author Caleb - cawasle
CIS175 - Fall 2021
Oct 6, 2021
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ListDetails {
	
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate tripDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Client client;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Employee> listOfItems;
	
	public ListDetails() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public ListDetails(int id, String listName, LocalDate tripDate, Client client, List<Employee> listOfItems) 
	{
		super();
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.client = client;
		this.listOfItems = listOfItems;
	}
	
	/*public ListDetails(int id, String listName, LocalDate tripDate, Client client, List<Employee> listOfItems)
	{
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.shopper = shopper;
		this.listOfItems = listOfItems;
	}*/
	
	public ListDetails(String listName, LocalDate tripDate, Client client, List<Employee> listOfItems)
	{
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.client = client;
		this.listOfItems = listOfItems;
	}
	
	public ListDetails(String listName, LocalDate tripDate, Client client)
	{
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.client = client;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}

	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}

	/**
	 * @return the tripDate
	 */
	public LocalDate getTripDate() {
		return tripDate;
	}

	/**
	 * @param tripDate the tripDate to set
	 */
	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the listOfItems
	 */
	public List<Employee> getListOfItems() {
		return listOfItems;
	}

	/**
	 * @param listOfItems the listOfItems to set
	 */
	public void setListOfItems(List<Employee> listOfItems) {
		this.listOfItems = listOfItems;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", tripDate=" + tripDate + ", client=" + client
				+ ", listOfItems=" + listOfItems + "]";
	}
}
