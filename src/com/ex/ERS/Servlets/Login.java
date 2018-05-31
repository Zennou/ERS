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
public class Login extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/db")
    private DataSource dataSource;
	private EmployeeDAO empDAO;
	private  HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login()
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
			Employee employee = new Employee();
			employee.setEmail(request.getParameter("uemail"));
			employee.setPassword(request.getParameter("upass"));
			
			employee= empDAO.login(employee);
			
    		Query query = session.createQuery("Select email, password from Employee where email = :email and password = :pass");
    		statement = conn.prepareStatement(query);
    		statement.setString("email");
    		statement.setString(3,pass);
    		statement.executeUpdate();
			
			if (employee.exists())
			{			        
		          session = request.getSession();	    
		          session.setAttribute("sessionUser", employee.getUsername()); 
		          session.setAttribute("sessionPass", employee.getPassword());
		          session.setAttribute("sessionRoleID", employee.getRoleID());
		          session.setAttribute("sessionFirstName", employee.getFirstname());
		          /*session.setAttribute("sessionLastName", ofTheWeek.getLastname());
		          session.setAttribute("sessionEmail", ofTheWeek.getEmail());*/
		          
		          if(employee.getRoleID() == 2)
		          {
		        	  request.getRequestDispatcher("home.jsp").forward(request, response);
		          }
		          else if (employee.getRoleID() == 1)
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

