package com.ex.ERS.DAOs;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.sql.DataSource;
import com.ex.ERS.DAOs.ConnectionUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.ERS.Employee;

public class EmployeeDAO
{
    private DataSource dataSource;
    private Connection conn;
    private PreparedStatement statement;
    private ResultSet selectStar;

    public EmployeeDAO(DataSource dataSource) 
    {
        this.dataSource = dataSource;
    }   
    
    public void updateFirstName(String user, String pass, String fname) throws SQLException
    {
    	try
    	{
	    	if(fname != null && !fname.trim().isEmpty())
	    	{
	    		String query = "UPDATE employees SET firstname = ? WHERE username = ? AND password = ?";
		        conn = dataSource.getConnection();
	    		statement = conn.prepareStatement(query);
	    		statement.setString(1,fname);
	    		statement.setString(2,user);
	    		statement.setString(3,pass);
	    		statement.executeUpdate();
	    	}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }    
    
    public void updateLastName(String user, String pass, String lname) throws SQLException
    {
    	try
    	{
	    	if(lname != null && !lname.trim().isEmpty())
	    	{
	    		String query = "UPDATE employees SET lastname = ? WHERE username = ? AND password = ?";
		        conn = dataSource.getConnection();
	    		statement = conn.prepareStatement(query);
	    		statement.setString(1,lname);
	    		statement.setString(2,user);
	    		statement.setString(3,pass);
	    		statement.executeUpdate();
	    	}
    	}
		catch (Exception e)
		{
			e.printStackTrace();
		}
    }
    
    public void updatePassword(String user, String pass, String newPass) throws SQLException
    {
    	try
    	{
	    	if(newPass != null && !newPass.trim().isEmpty())
	    	{
	    		String query = "UPDATE employees SET password = ? WHERE username = ? AND password = ?";
		        conn = dataSource.getConnection();
	    		statement = conn.prepareStatement(query);
	    		statement.setString(1,newPass);
	    		statement.setString(2,user);
	    		statement.setString(3,pass);
	    		statement.executeUpdate();
	    	}
    	}
    	finally{}  
    }    
    
    public Employee login(Employee employee)
    {
		Session session = ConnectionUtil.getSession();
    	String uName = employee.getEmail();
    	String uPass = employee.getPassword();
    	Query query = session.createQuery("From Employee where email = :uEmail and password = :uPass");
    	List<Employee> list = query.list();
    	Iterator iterator = list.iterator();
    	Transaction transaction = session.beginTransaction();
    	
    	while(iterator.hasNext())
    	{
    		Employee emp = (Employee)iterator.next();
        	employee.setID(emp.getID());
        	employee.setEmail(emp.getEmail());
        	employee.setPassword(emp.getPassword());
        	employee.setFirstname(emp.getFirstname());
        	employee.setLastname(emp.getLastname());
        	employee.setRoleID(emp.getRoleID());    		
    	}
    	
    	

    	try
    	{
	        conn = dataSource.getConnection();
	        statement = conn.prepareStatement(query);
	        statement.setString(1, uName);
	        statement.setString(2, uPass);
	        selectStar = statement.executeQuery();	        

	        statement = conn.prepareStatement(query1);
	        statement.setString(1, uName);
	        statement.setString(2, uPass);
	        ResultSet selectStar1 = statement.executeQuery();
	
	        if(selectStar.next() && selectStar1.next())
	        {
	        	employee.setID(selectStar.getInt("id"));
	        	employee.setEmail(selectStar.getString("email"));
	        	employee.setPassword(selectStar.getString("password"));
	        	employee.setFirstname(selectStar.getString("firstname"));
	        	employee.setLastname(selectStar.getString("lastname"));
	        	employee.setRoleID(selectStar.getInt("rol	e_id"));
	        }
	        conn.close();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	finally
        {
            if (selectStar != null)	
            {
               try 
               {
            	   selectStar.close();
               }
               catch (Exception e) 
               {
            	   e.printStackTrace();
               }
               selectStar = null;
            }
   	
            if (statement != null)
            {
               try
               {
                  statement.close();
               }
               catch (Exception e)
               {
            	   e.printStackTrace();
               }
                  statement = null;
            }
   	
            if (conn != null) 
            {
               try
               {
                  conn.close();
               }
               catch (Exception e) 
               {
            	   e.printStackTrace();
               }
               conn = null;
            }
         }
        return employee;
    }

    public List<Employee> list(String userName, String userPass) throws SQLException
    {
        ArrayList<Employee> employees = new ArrayList<>();
        
        try
        {
        	String query = "SELECT id, firstname, lastname, email, role_id from employees WHERE username = ? AND password = ?";
        	Connection conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
    		statement.setString(1, userName);  
    		statement.setString(2, userPass);  
            selectStar = statement.executeQuery();

            while (selectStar.next()) 
            {
                Employee mvp = new Employee();
                mvp.setID(selectStar.getInt("id"));
                mvp.setFirstname(selectStar.getString("firstname"));
                mvp.setLastname(selectStar.getString("lastname"));
                mvp.setEmail(selectStar.getString("email"));
                mvp.setRoleID(selectStar.getInt("role_id"));
                employees.add(mvp);
            }
            return employees;
        }
        finally{}
    }
}