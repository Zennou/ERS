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
import com.ex.ERS.DAOs.*;

/**
 * Servlet implementation class CreateReimbursement
 */
@WebServlet("/create_reimbursement")
public class CreateReimbursement extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/db")
    private DataSource dataSource;
	private TypeDAO typeDAO;
	private ReimbursementDAO reiDAO;
	private HttpSession session;
       
    @Override
    public void init()
    {
        typeDAO = new TypeDAO();
        reiDAO = new ReimbursementDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			Employee user = (Employee) request.getSession(true).getAttribute("employee");
			
			@SuppressWarnings("unlikely-arg-type")
			int typeID = typeDAO.getTypes().indexOf(request.getParameter("reiType"));
			int authID = user.getID();
			double amount = Double.parseDouble(request.getParameter("reiAmount"));
			String description = request.getParameter("reiDescription");

			reiDAO.addReimbursement(authID, typeID, amount, description);
	        session = request.getSession();
			session.setAttribute("sessionMessage", "Reimbursement successfully added");
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
		doGet(request, response);
	}

}
