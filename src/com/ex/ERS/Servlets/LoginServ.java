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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServ extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/db")
    private DataSource dataSource;
	private EmployeeDAO empDAO;
	private  HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ()
    {
        super();
        // Auto-generated constructor stub
    }

    @Override
    public void init()
    {
        empDAO = new EmployeeDAO(dataSource);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			Employee ofTheWeek = new Employee();
			ofTheWeek.setUsername(request.getParameter("uname"));
			ofTheWeek.setPassword(request.getParameter("upass"));
			
			ofTheWeek= empDAO.login(ofTheWeek);
			
			if (ofTheWeek.exists())
			{			        
		          session = request.getSession();	    
		          session.setAttribute("sessionUser", ofTheWeek.getUsername()); 
		          session.setAttribute("sessionPass", ofTheWeek.getPassword());
		          session.setAttribute("sessionRoleID", ofTheWeek.getRoleID());
		          session.setAttribute("sessionFirstName", ofTheWeek.getFirstname());
		          /*session.setAttribute("sessionLastName", ofTheWeek.getLastname());
		          session.setAttribute("sessionEmail", ofTheWeek.getEmail());*/
		          
		          if(ofTheWeek.getRoleID() == 2)
		          {
		        	  request.getRequestDispatcher("home.jsp").forward(request, response);
		          }
		          else if (ofTheWeek.getRoleID() == 1)
		          {
				        request.getRequestDispatcher("managerHome.jsp").forward(request, response);
		          }
		          else
		          {
			        session.setAttribute("sessionError", "Invalid user name/password");
			        request.getRequestDispatcher("loginError.jsp").forward(request, response);
		  		}
		     }
			else
			{	   
		        session.setAttribute("sessionError", "This user is not in our records.");
		        request.getRequestDispatcher("response.jsp").forward(request, response);
			}
		}
		catch(Exception e)
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

