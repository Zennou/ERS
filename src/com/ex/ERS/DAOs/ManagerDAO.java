package com.ex.ERS.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ex.ERS.Employee;
import com.ex.ERS.Reimbursement;

public class ManagerDAO
{    
    private DataSource dataSource;
	private ResultSet selectStar;
	
	public ManagerDAO(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }   

	public List<Employee> listALL() throws SQLException
    {
        ArrayList<Employee> employees = new ArrayList<>();
        
        try
        {
        	String query = "SELECT id, firstname, lastname, email, role_id from employees";
        	Connection conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
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

    public List<Reimbursement> listPending() throws SQLException
    {
        ArrayList<Reimbursement> reimbursements = new ArrayList<>();
    	String query = "SELECT id, author_id, resolver_id, type_id, status_id, created_date, modified_date, amount from reimbursements WHERE status_id = 1";
    	
        try
        { 
        	Connection conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            selectStar = statement.executeQuery();

            while (selectStar.next()) 
            {
                Reimbursement rei = new Reimbursement();
                rei.setId(selectStar.getInt("id"));
                rei.setTypeID(selectStar.getInt("type_id"));
                rei.setAuthorID(selectStar.getInt("author_id"));
                rei.setResolverID(selectStar.getInt("resolver_id"));
                rei.setCreatedDate(selectStar.getDate("created_date"));
                rei.setModifiedDate(selectStar.getDate("modified_date")); 
                rei.setAmount(selectStar.getDouble("amount"));
                reimbursements.add(rei);
            }
	        conn.close();
            return reimbursements;
        }
        finally{}
    }
    
    public List<Reimbursement> listDenied() throws SQLException
    {
        ArrayList<Reimbursement> reimbursements = new ArrayList<>();
    	String query = "SELECT id, author_id, resolver_id, type_id, status_id, created_date, modified_date, amount FROM reimbursements WHERE status_id = 3";
    	
        try
        { 
        	Connection conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            selectStar = statement.executeQuery();

            while (selectStar.next()) 
            {
                Reimbursement rei = new Reimbursement();
                rei.setId(selectStar.getInt("id"));
                rei.setTypeID(selectStar.getInt("type_id"));
                rei.setAuthorID(selectStar.getInt("author_id"));
                rei.setResolverID(selectStar.getInt("resolver_id"));
                rei.setCreatedDate(selectStar.getDate("created_date"));
                rei.setModifiedDate(selectStar.getDate("modified_date")); 
                rei.setAmount(selectStar.getDouble("amount"));
                reimbursements.add(rei);
            }
	        conn.close();
            return reimbursements;
        }
        finally{}
    }

    public List<Reimbursement> listResolved() throws SQLException
    {
        ArrayList<Reimbursement> reimbursements = new ArrayList<>();
    	String query = "SELECT id, author_id, resolver_id, type_id, status_id, created_date, modified_date, amount from reimbursements WHERE status_id = 2";
        
        try
        { 
        	Connection conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            selectStar = statement.executeQuery();

            while (selectStar.next()) 
            {
                Reimbursement rei = new Reimbursement();
                rei.setId(selectStar.getInt("id"));
                rei.setTypeID(selectStar.getInt("type_id"));
                rei.setAuthorID(selectStar.getInt("author_id"));
                rei.setResolverID(selectStar.getInt("resolver_id"));
                rei.setCreatedDate(selectStar.getDate("created_date"));
                rei.setModifiedDate(selectStar.getDate("modified_date")); 
                rei.setAmount(selectStar.getDouble("amount"));
                reimbursements.add(rei);
            }
	        conn.close();
            return reimbursements;
        }
        finally{}
    }
}
