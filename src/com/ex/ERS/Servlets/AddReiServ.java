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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.ex.ERS.Employee;
import com.ex.ERS.DAOs.*;

/**
 * Servlet implementation class AddReiServ
 */
@WebServlet("/create_reimbursement")
public class AddReiServ extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/db")
    private DataSource dataSource;
	private EmployeeDAO empDAO;
	private TypeDAO typeDAO;
	private ReiDAO reiDAO;
	private HttpSession session;
       
    @Override
    public void init()
    {
        empDAO = new EmployeeDAO(dataSource);
        typeDAO = new TypeDAO(dataSource);
        reiDAO = new ReiDAO(dataSource);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			String userName = (String) request.getSession(true).getAttribute("sessionUser");
			String userPass = (String) request.getSession(true).getAttribute("sessionPass");
			
			List<Employee> emps = empDAO.list(userName, userPass);
			
			int authID = emps.get(0).getId();
			int typeID =  typeDAO.list().indexOf(request.getParameter("reiType"));
			double amount = Double.parseDouble(request.getParameter("reiAmount"));
			String description = request.getParameter("reiDescription");
			
			reiDAO.addReimbursement(authID, typeID, amount, description);			        
	        session = request.getSession();	
			session.setAttribute("sessionError", "Reimbursement successfully added");
            request.getRequestDispatcher("reiAdded.jsp").forward(request, response);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
