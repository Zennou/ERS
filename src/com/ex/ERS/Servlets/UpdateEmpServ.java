package com.ex.ERS.Servlets;

import java.io.IOException; 

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.ex.ERS.Employee;
import com.ex.ERS.DAOs.EmployeeDAO;

/**
 * Servlet implementation class UpdateEmpServ
 */
@WebServlet("/update_employee")
public class UpdateEmpServ extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/db")
    private DataSource dataSource;
	private EmployeeDAO empDAO;
	private HttpSession session;
       
    @Override
    public void init()
    {
        empDAO = new EmployeeDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			Employee employee = (Employee) request.getAttribute("employee");
			//String email = request.getParameter("empEmail");
			String firstname = request.getParameter("empFirstName");
			String lastname = request.getParameter("empLastName");
			String newPassword = request.getParameter("empPassword");
			//empDAO.updateEmail(employee.getEmail(), email);
			empDAO.updateFirstName(employee.getEmail(), firstname);
			empDAO.updateLastName(employee.getEmail(), lastname);
			empDAO.updatePassword(employee.getEmail(), newPassword);
			session.setAttribute("sessionMessage", "Your information has been updated");
            request.getRequestDispatcher("response.jsp").forward(request, response);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
