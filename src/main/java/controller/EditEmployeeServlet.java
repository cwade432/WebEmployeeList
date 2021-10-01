package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;

/**
 * Servlet implementation class editEmployeeServlet
 */
@WebServlet("/editEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		EmployeeHelper dao = new EmployeeHelper();
		
		String name = request.getParameter("name"); // grabs name from edit-employee text box
		String address = request.getParameter("address"); // grabs address from edit-employee text box
		String position = request.getParameter("position"); // grabs position from edit-employee text box
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Employee itemToUpdate = dao.searchForEmployeeById(tempId); // search for employee with matching id
		itemToUpdate.setName(name); // set new name
		itemToUpdate.setAddress(address); // set new address
		itemToUpdate.setPosition(position); // set new position
		
		dao.updateEmployee(itemToUpdate); // update employee with method from EmployeeHelper
		
		getServletContext().getRequestDispatcher("/viewAllEmployeesServlet").forward(request, response); // sends user back to employee list page
	}

}
