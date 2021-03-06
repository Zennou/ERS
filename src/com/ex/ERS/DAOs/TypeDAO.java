package com.ex.ERS.DAOs;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ex.ERS.Type;

public class TypeDAO
{
    public Type getType(String id)
    {
    	Session session = ConnectionUtil.getSession();
    	Transaction transaction = null;
    	Type type = null;
    	try
    	{
    		transaction = session.getTransaction();
    		transaction.begin();

    		@SuppressWarnings("unchecked")
			Query<Type> query = session.createQuery("FROM Type WHERE id ='" + id + "'");
    		type = (Type)query.uniqueResult();
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
		return type;    	
    }

    @SuppressWarnings("unchecked")
	public List<Type> getTypes()
    {        
		List<Type> types = new ArrayList<Type>();
    	Session session = ConnectionUtil.getSession();
    	Transaction transaction = null;
    	try
    	{
    		transaction = session.getTransaction();
    		transaction.begin();
    		types = session.createQuery("FROM Type").list();
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
		return types;
    }    
}

/*Old Code
package com.ex.ERS.DAOs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.ex.ERS.Type;

public class TypeDAO
{
    private DataSource dataSource;

    public TypeDAO(DataSource dataSource) 
    {
        this.dataSource = dataSource;
    }
    
    public List<String> list() throws SQLException
    {
    	List<String> types = new ArrayList<>();
    	try
    	{
    		String query = "SELECT type.id, type.name FROM type";
            Connection conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            String name;
            while (resultSet.next()) 
            {
                name = resultSet.getString("name");
            	types.add(name);
            }
	        conn.close();
            return types;
    	}
    	finally{}
    }    
    
    public List<Type> list(String userName) throws SQLException
    {
    	ArrayList<Type> types = new ArrayList<>();
    	
    	try
    	{
    		String query = "SELECT type.id, type.name FROM type JOIN reimbursements ON reimbursements.type_id = type.id JOIN employees on employees.id=reimbursements.author_id WHERE employees.email = ?";
            Connection conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
    		statement.setString(1, userName);  
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) 
            {
                Type typical = new Type();
                typical.setId(resultSet.getInt("id"));
                typical.setName(resultSet.getString("name"));
                types.add(typical);
            }
	        conn.close();
            return types;
    	}
    	finally{}
    }
}
*/