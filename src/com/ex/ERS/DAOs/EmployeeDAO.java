package com.ex.ERS.DAOs;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
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
    
    public Employee login(Employee vip)
    {    	
    	String uName = vip.getUsername();
    	String uPass = vip.getPassword();
    	String query = "Select employees.id, username, email, password, firstname, lastname, role_id FROM employees JOIN role ON employees.role_id = role.id WHERE username = ? AND password = ?";
    	String query1 = "Select name FROM role JOIN employees ON employees.role_id = role.id WHERE employees.username = ? AND employees.password = ?";

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
	        	vip.setId(selectStar.getInt("id"));
	        	vip.setEmail(selectStar.getString("email"));
	        	vip.setPassword(selectStar.getString("password"));
	        	vip.setFirstname(selectStar.getString("firstname"));
	        	vip.setLastname(selectStar.getString("lastname"));
	        	vip.setRoleID(selectStar.getInt("role_id"));
	        	vip.setRoleName(selectStar1.getString("name"));
	        	vip.setExists(true);       
	        }
	        else
	        {
	        	vip.setExists(false);
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
        return vip;
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
                mvp.setId(selectStar.getInt("id"));
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