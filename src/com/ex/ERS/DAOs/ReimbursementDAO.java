package com.ex.ERS.DAOs;
import java.sql.*; 
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.ex.ERS.Reimbursement;

public class ReiDAO
{
    private DataSource dataSource;
    private ResultSet resultSet;

    public ReiDAO(DataSource dataSource) 
    {
        this.dataSource = dataSource;
    }
    
    public void addReimbursement(int authID, int typeID, double amount, String description) throws SQLException
    {
    	try
    	{
			String query = "INSERT INTO reimbursements (author_id, type_id, amount, description) VALUES (?,?,?,?)";
			Connection conn = dataSource.getConnection();
	        PreparedStatement statement = conn.prepareStatement(query);
	        statement.setInt(1,authID);
	        statement.setInt(2,typeID);
	        statement.setDouble(3,amount);
	        statement.setString(4, description);
	        statement.executeUpdate();
	        conn.close();
    	}
    	finally{}
    	
    }
    
    public List<Reimbursement> list(String userName, int statID) throws SQLException
    {
        ArrayList<Reimbursement> reimbursements = new ArrayList<>();
        
        try
        {
        	String query = "SELECT reimbursements.id, resolver_id, author_id, created_date, modified_date, description, amount, status_id, type_id FROM reimbursements JOIN status ON status.id=reimbursements.status_id JOIN employees ON employees.id=reimbursements.author_id WHERE employees.username = ? AND status.id= ? ORDER BY reimbursements.id";        	
            
            
        	Connection conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
    		statement.setString(1, userName);  
    		statement.setInt(2, statID);  
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) 
            {
                Reimbursement rei = new Reimbursement();
                rei.setId(resultSet.getInt("id"));
                rei.setAuthorID(resultSet.getInt("author_id"));
                rei.setResolverID(resultSet.getInt("resolver_id"));
                rei.setTypeID(resultSet.getInt("type_id"));
                rei.setStatusID(resultSet.getInt("status_id"));
                rei.setCreatedDate(resultSet.getDate("created_date"));
                rei.setModifiedDate(resultSet.getDate("modified_date"));
                rei.setDescription(resultSet.getString("description"));
                rei.setAmount(resultSet.getDouble("amount"));
                reimbursements.add(rei);
            }
	        conn.close();
            return reimbursements;
        }
        finally{}
    }
}