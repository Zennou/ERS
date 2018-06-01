package com.ex.ERS.Servlets;
import java.io.IOException; 
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import com.ex.ERS.Employee;
import com.ex.ERS.Reimbursement;
import com.ex.ERS.DAOs.ReimbursementDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/reimbursements")
public class ListReimbursement extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/db")
    private DataSource dataSource;
    private ReimbursementDAO reiDAO;
    
    @Override
    public void init()
    {
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
            List<Reimbursement> reimbursements = reiDAO.getReimbursementsByUser(user.getEmail());
            request.setAttribute("reimbursements", reimbursements);
            request.getRequestDispatcher("reimbursements.jsp").forward(request, response);
        }
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}