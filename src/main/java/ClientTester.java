import java.util.List;

import controller.ClientHelper;
import model.Client;

/**
 * @author Caleb - cawasle
CIS175 - Fall 2021
Oct 6, 2021
 */


public class ClientTester {

	public static void main(String[] args)
	{
		Client cameron = new Client("Cameron");
		//Client jim = new Client("Jim");
		
		ClientHelper sh = new ClientHelper();
		
		sh.insertClient(cameron);
		//sh.insertClient(jim);
		
		List<Client> allShoppers = sh.showAllCLients();
		
		for (Client a : allShoppers)
		{
			System.out.println(a.toString());
		}
		
	}
	
}
