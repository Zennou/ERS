package com.ex.ERS.DAOs;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ex.ERS.Role;

public class RoleDAO
{
    public Role getRole(String roleID)
    {
    	Session session = ConnectionUtil.getSession();
    	Transaction transaction = null;
    	Role role = null;
    	try
    	{
    		transaction = session.getTransaction();
    		transaction.begin();
    		
    		@SuppressWarnings("unchecked")
			Query<Role> query = session.createQuery("FROM Role WHERE id ='" + roleID + "'");
    		role = (Role)query.uniqueResult();
    		transaction.commit();    		
    	}
		catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return role;    	
    }

	@SuppressWarnings("unchecked")
	public List<Role> getRoles()
    {        
		List<Role> roles = new ArrayList<Role>();
    	Session session = ConnectionUtil.getSession();
    	Transaction transaction = null;
    	try
    	{
    		transaction = session.getTransaction();
    		transaction.begin();
    		roles = session.createQuery("FROM Role").list();
    		transaction.commit();    		
    	}
		catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return roles;
    }
}

/* Old Code
package com.ex.ERS.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ex.ERS.Role;

public class RoleDAO
{
    private DataSource dataSource;
    private Connection conn;
    private PreparedStatement statement;
    private ResultSet selectStar;     
    
	public RoleDAO(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	public List<Role> list(String userName, String userPass) throws SQLException
    {
        ArrayList<Role> roles = new ArrayList<>();
        
        try
        {
        	String query = "SELECT employees.id, name FROM role JOIN employees ON employees.role_id = role.id WHERE email = ? AND password = ?";
        	conn = dataSource.getConnection();
            statement = conn.prepareStatement(query);
    		statement.setString(1, userName);  
    		statement.setString(2, userPass);  
            selectStar = statement.executeQuery();

            while (selectStar.next()) 
            {
                Role supportive = new Role();
                supportive.setID(selectStar.getInt("id"));
                supportive.setName(selectStar.getString("name"));
                roles.add(supportive);
            }
        	selectStar.close();	
	        conn.close();
            return roles;
        }
        finally{}
    }
}
*/