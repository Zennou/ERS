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
