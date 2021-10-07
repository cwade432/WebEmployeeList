/**
 * @author Caleb - cawasle
CIS175 - Fall 2021
Oct 6, 2021
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue
	private int id;
	private String clientName;
	
	public Client() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Client(int id, String clientName) {
		super();
		this.id = id;
		this.clientName = clientName;
	}
	
	public Client(String clientName)
	{
		super();
		this.clientName = clientName;
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
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", clientName=" + clientName + "]";
	}
}
