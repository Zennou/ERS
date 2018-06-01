package com.ex.ERS.DAOs;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ex.ERS.Status;

public class StatDAO
{    
    @SuppressWarnings("unchecked")
	public List<Status> getStatuses(String userName) throws SQLException
    {        
		List<Status> statuses = new ArrayList<Status>();
    	Session session = ConnectionUtil.getSession();
    	Transaction transaction = null;
    	try
    	{
    		transaction = session.getTransaction();
    		transaction.begin();
    		statuses = session.createQuery("FROM Status").list();
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
		return statuses;
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

import com.ex.ERS.Status;

public class StatDAO
{
    private DataSource dataSource;

    public StatDAO(DataSource dataSource) 
    {
        this.dataSource = dataSource;
    }
    
    public List<Status> list(String userName) throws SQLException
    {
    	ArrayList<Status> statuses = new ArrayList<>();
    	
    	try
    	{
    		String query = "SELECT id, name FROM status JOIN employees ON employees.status_id = status.id WHERE employees.email = ?";

            Connection conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
    		statement.setString(1, userName);  
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) 
            {
                Status stat = new Status();
                stat.setID(resultSet.getInt("id"));
                stat.setName(resultSet.getString("name"));
                statuses.add(stat);
            }
            resultSet.close();
	        conn.close();
            return statuses;
    	}
    	finally{}
    }

}
*/