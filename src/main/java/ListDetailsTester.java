import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ClientHelper;
import controller.ListDetailsHelper;
import model.Client;
import model.Employee;
import model.ListDetails;

/**
 * @author Caleb - cawasle
CIS175 - Fall 2021
Oct 6, 2021
 */

public class ListDetailsTester {

	public static void main(String[] args)
	{
		Client cameron = new Client("Cameron"); // I think this needs to be taken out since already persisting
		//ClientHelper sh = new ClientHelper();
		
		//sh.insertClient(cameron);
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		Employee appleStock = new Employee("NASDAQ", "APPL", "Stock");
		Employee microsoftStock = new Employee("NASDAQ", "MSFT", "Stock");
		
		List<Employee> cameronsItems = new ArrayList<Employee>();
		cameronsItems.add(appleStock);
		cameronsItems.add(microsoftStock);
		
		ListDetails cameronsList = new ListDetails("Camerons Portfollio", LocalDate.now(), cameron);
		
		cameronsList.setListOfItems(cameronsItems);
		
		ldh.insertNewListDetails(cameronsList);
		
		List<ListDetails> allLists = ldh.getLists();
		
		for(ListDetails a : allLists)
		{
			System.out.println(a.toString());
		}
	}
	
}

// Took out instaiating cameron the shopper, I think that it will auto persist the name so I dont need to create it
