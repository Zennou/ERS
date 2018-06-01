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
import com.ex.ERS.DAOs.ReiDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/reimbursements")
public class ReiServ extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/db")
    private DataSource dataSource;
    private ReiDAO reiDAO;
    
    @Override
    public void init()
    {
        reiDAO = new ReiDAO(dataSource);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
        try
        {
			String un = (String) request.getSession(true).getAttribute("sessionUser");
            List<Reimbursement> reiPending = reiDAO.list(un,1);
            List<Reimbursement> reiApproved = reiDAO.list(un,2);
            List<Reimbursement> reiDenied = reiDAO.list(un,3);
            request.setAttribute("pending", reiPending);
            request.setAttribute("approved", reiApproved);
            request.setAttribute("denied", reiDenied);
            request.getRequestDispatcher("reimbursements.jsp").forward(request, response);
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
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}*/
}