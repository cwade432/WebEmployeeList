/**
 * @author Caleb - cawasle
CIS175 - Fall 2021
Sep 28, 2021
 */

import java.util.List;
import java.util.Scanner;

import controller.EmployeeHelper;
import model.Employee;

public class StartProgram {

	static Scanner input = new Scanner(System.in);
	static EmployeeHelper eh = new EmployeeHelper();
	
	private static void addAnEmployee()
	{
		System.out.print("Enter in employee name: ");
		String empName = input.nextLine();
		System.out.print("Enter in employee address: ");
		String empAddress = input.nextLine();
		System.out.print("Enter in employee position: ");
		String empPosition = input.nextLine();
		Employee toAdd = new Employee(empName, empAddress, empPosition);
		eh.addEmployee(toAdd);		
	}
	
	private static void editAnEmployee()
	{
		System.out.println("How would you like to search? ");
		System.out.println("1) Search by Name");
		System.out.println("2) Search by Address");
		System.out.println("3) Search by position");
		int searchBy = input.nextInt();
		input.nextLine();
		List<Employee> foundItems = null;
		if (searchBy == 1) 
		{
			System.out.print("Enter the employee name: ");
			String employeeName = input.nextLine();
			foundItems = eh.searchForEmployeeByName(employeeName);
			
		} 
		else if(searchBy == 2)
		{
			System.out.print("Enter the employee address: ");
			String employeeAddress = input.nextLine();
			foundItems = eh.searchForEmployeeByAddress(employeeAddress);
		}
		else if(searchBy == 3)
		{
			System.out.print("Enter the employee position: ");
			String employeePosition = input.nextLine();
			foundItems = eh.searchForEmployeeByPosition(employeePosition);
		}
		else
		{
			System.out.println("Whoops");
		}

		if (!foundItems.isEmpty()) 
		{
			System.out.println("Found Results.");
			for (Employee l : foundItems) 
			{
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = input.nextInt();

			Employee toEdit = eh.searchForEmployeeById(idToEdit);
			System.out.println("Retrieved " + toEdit.getName() + " from " + toEdit.getAddress());
			System.out.println("1) Update Name");
			System.out.println("2) Update Address");
			System.out.println("3) Update Position");
			int update = input.nextInt();
			input.nextLine();

			if (update == 1) 
			{
				System.out.print("New Name: ");
				String newName = input.nextLine();
				toEdit.setName(newName);
			} 
			else if (update == 2) 
			{
				System.out.print("New Address: ");
				String newAddress = input.nextLine();
				toEdit.setAddress(newAddress);
			}
			else if (update == 3) 
			{
				System.out.print("New Position: ");
				String newPosition = input.nextLine();
				toEdit.setPosition(newPosition);
			}

			eh.updateEmployee(toEdit);

		} // end of if items found loop
		else 
		{
			System.out.println("No results found");
		}
	}
	
	private static void deleteAnEmployee()
	{
		System.out.println("Enter employee name to delete");
		String name = input.nextLine();
		System.out.println("Enter in address to delete");
		String address = input.nextLine();
		System.out.println("Enter in position to delete");
		String position = input.nextLine();
		Employee toDelete = new Employee(name, address, position);
		eh.deleteEmployee(toDelete);
	}
	
	public static void main(String[] args)
	{
		menu();
	}
	
	public static void menu()
	{
		boolean goAgain = true;
		System.out.println("--- New Employee List ---");
		while (goAgain) 
		{
			System.out.println("*  Select an action:");
			System.out.println("*  1.) Add an employee");
			System.out.println("*  2.) Edit an employee");
			System.out.println("*  3.) Delete an employee");
			System.out.println("*  4.) View the employee list");
			System.out.println("*  5.) Exit");
			System.out.print("*  Your selection: ");
			int selection = input.nextInt();
			input.nextLine();

			if (selection == 1) 
			{
				addAnEmployee();
			} 
			else if (selection == 2) 
			{
				editAnEmployee();
			} 
			else if (selection == 3) 
			{
				deleteAnEmployee();
			} 
			else if (selection == 4) 
			{
				viewEmployeeList();
			}
			else {
					eh.cleanUp();
					System.out.println("..Cleaning up.....");
					System.out.println("   Goodbye!   ");
					goAgain = false;
				 }
		} // end of while loop
	}
	
	public static void viewEmployeeList()
	{
		List<Employee> allEmployees = eh.showAllEmployees();
		
		for(Employee singleEmployee : allEmployees)
		{
			System.out.println(singleEmployee.returnEmployeeDetails());
		}
	}
	
}

