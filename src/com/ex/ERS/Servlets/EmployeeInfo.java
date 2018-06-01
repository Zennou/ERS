package com.ex.ERS.Servlets;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import com.ex.ERS.Employee;
import com.ex.ERS.Role;
import com.ex.ERS.DAOs.*;

/**
 * Servlet implementation class EmployeeInfo
 */
@WebServlet("/employee_info")
public class EmployeeInfo extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/db")
    private DataSource dataSource;
	private EmployeeDAO empDAO;
	private RoleDAO roleDAO;
       
    @Override
    public void init()
    {
        empDAO = new EmployeeDAO();
        roleDAO = new RoleDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			Employee user = (Employee) request.getSession(true).getAttribute("employee");
			Employee emps = empDAO.getEmployee(user.getEmail());
			Role roles = roleDAO.getRole(user.getEmail());
			request.setAttribute("employeeList", emps);
			request.setAttribute("roleList", roles);
            request.getRequestDispatcher("employeeInfo.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//  Auto-generated method stub
		doGet(request, response);
	}

}

/*
package com.ex.ERS.Servlets;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.ex.ERS.Employee;
import com.ex.ERS.Role;
import com.ex.ERS.DAOs.*;

*//**
 * Servlet implementation class EmployeeInfo
 *//*
@WebServlet("/employee_info")
public class EmployeeInfo extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/db")
    private DataSource dataSource;
	private EmployeeDAO empDAO;
	private RoleDAO roleDAO;
       
    @Override
    public void init()
    {
        empDAO = new EmployeeDAO();
        roleDAO = new RoleDAO();
    }

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			String userName = (String) request.getSession(true).getAttribute("sessionUser");
			String userPass = (String) request.getSession(true).getAttribute("sessionPass");
			List<Employee> emps = empDAO.list(userName, userPass);
			List<Role> roles = roleDAO.getRoleByEmail(userName, userPass);
			request.setAttribute("employeeList", emps);
			request.setAttribute("roleList", roles);
            request.getRequestDispatcher("employeeInfo.jsp").forward(request, response);
		}
        catch (SQLException e)
        {
            throw new ServletException("We are unable to obtain the reimbursements from our records", e);
        }
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  Auto-generated method stub
		doGet(request, response);
	}

}
*/