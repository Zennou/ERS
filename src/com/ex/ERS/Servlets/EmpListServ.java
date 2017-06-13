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
import com.ex.ERS.DAOs.ManagerDAO;

/**
 * Servlet implementation class EmpListServ
 */
@WebServlet("/employee_list")
public class EmpListServ extends HttpServlet {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			List<Employee> allEmps = manDAO.listALL();
			request.setAttribute("allEmployees", allEmps);
            request.getRequestDispatcher("employeeList.jsp").forward(request, response);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
