package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;

/**
 * Servlet implementation class NavigationSerlvet
 */
@WebServlet("/employeeNavigationSerlvet")
			
public class NavigationSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);		
		EmployeeHelper dao = new EmployeeHelper();
		String act = request.getParameter("doThisToItem"); // grabs what button is clicked
		String path = "/viewAllEmployeesServlet";
		
		if(act.equals("delete")) // if the delete button is clicked
		{
			try
			{
				Integer tempId = Integer.parseInt(request.getParameter("id")); // parse object and grabbing the id of the selection we want to delete
				Employee itemToDelete = dao.searchForEmployeeById(tempId); // searching for employee by id
				dao.deleteEmployee(itemToDelete); // the id that is returned is the itemToDelete
			}
			catch(NumberFormatException e)
			{
				System.out.println("Forgot to select an item"); // if no selection is made but button is clicked
			}
		}
		else if(act.equals("edit")) // if the edit button is clicked
		{
			try
			{
				Integer tempId = Integer.parseInt(request.getParameter("id")); // parse object and grabbing the id of the selection we want to edit
				Employee itemToEdit = dao.searchForEmployeeById(tempId); // searching for employee by id
				request.setAttribute("itemToEdit", itemToEdit);
				path = "/edit-employee.jsp"; // redirect them to edit-employee
			}
			catch(NumberFormatException e)
			{
				System.out.println("Forgot to select an item");
			}
		}
		else if(act.equals("add")) // if the add button is clicked redirect to index page
		{
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
