/**
 * @author Caleb - cawasle
CIS175 - Fall 2021
Sep 28, 2021
 */

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "EMPLOYEENAME")
	private String name;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "POSITION")
	private String position;
	
	public Employee()
	{
		super();
	}

	public Employee(String name, String address, String position)
	{
		super();
		this.name = name;
		this.address = address;
		this.position = position;
	}
	
	/**
	 * @return the id
	 */
	public int getId() 
	{
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) 
	{
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() 
	{
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) 
	{
		this.address = address;
	}

	/**
	 * @return the position
	 */
	public String getPosition() 
	{
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) 
	{
		this.position = position;
	}
	
	public String returnEmployeeDetails()
	{
		return "ID: " + this.id + " | " + "Name: " + this.name + " | " + "Address: " + this.address + " | " + "Position: " + this.position;
	}
	
	
}

