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

import com.ex.ERS.Reimbursement;
import com.ex.ERS.DAOs.ManagerDAO;

/**
 * Servlet implementation class ManReiServ
 */
@WebServlet("/user_requests")
public class ManReiServ extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/db")
    private DataSource dataSource;
    private ManagerDAO manDAO;
    
    @Override
    public void init()
    {
        manDAO = new ManagerDAO(dataSource);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
        try
        {
			//String un = (String) request.getSession(true).getAttribute("sessionEmail");
            List<Reimbursement> pending = manDAO.listPending();
            List<Reimbursement> approved = manDAO.listResolved();
            List<Reimbursement> denied = manDAO.listDenied();
            
            request.setAttribute("pending", pending);
            request.setAttribute("approved", approved);
            request.setAttribute("pending", denied);
            
            request.getRequestDispatcher("manReimbursements.jsp").forward(request, response);
        }
        catch (SQLException e)
        {
            throw new ServletException("We are unable to obtain the reimbursements from our records", e);
        }
		catch(Throwable e)
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
