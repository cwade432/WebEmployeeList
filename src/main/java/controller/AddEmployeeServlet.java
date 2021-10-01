package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String name = request.getParameter("name"); // pulling input from name
		String address = request.getParameter("address"); // pulling input from address
		String position = request.getParameter("position"); // pulling input from position
		
		Employee li = new Employee(name, address, position);
		EmployeeHelper dao = new EmployeeHelper();
		dao.addEmployee(li);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response); // directs where we want to go next
	}

}
