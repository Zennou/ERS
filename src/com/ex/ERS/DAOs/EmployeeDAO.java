package com.ex.ERS.DAOs;
import java.util.ArrayList;
import java.util.List;
import com.ex.ERS.DAOs.ConnectionUtil;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ex.ERS.Employee;

public class EmployeeDAO
{    
    public void updateFirstName(String email, String fname)
    {
		Session session = ConnectionUtil.getSession();
		Transaction transaction = session.beginTransaction();

    	try
    	{
    		transaction = session.getTransaction();
    		transaction.begin();

    		@SuppressWarnings("unchecked")
    		Query<Employee> query = session.createQuery("UPDATE Employee SET firstname = :first WHERE email = :email");
        	query.setParameter(1, fname);
        	query.setParameter(2, email);
        	query.executeUpdate();
        	transaction.commit();
        	session.close();
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
    }    
    
    public void updateLastName(String email, String lname)
    {
		Session session = ConnectionUtil.getSession();
		Transaction transaction = session.beginTransaction();

    	try
    	{
			@SuppressWarnings("unchecked")
			Query<Employee> query = session.createQuery("UPDATE Employee SET lastname = :last WHERE email = :email");
			query.setParameter(1, lname);
			query.setParameter(2, email);
			query.executeUpdate();
			transaction.commit();
			session.close();
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
    }
    
    public void updatePassword(String email, String newPass)
    {
		Session session = ConnectionUtil.getSession();
		Transaction transaction = session.beginTransaction();

    	try
    	{
			@SuppressWarnings("unchecked")
			Query<Employee> query = session.createQuery("UPDATE Employee SET password = :newPass WHERE email = :email");
			query.setParameter(1, newPass);
			query.setParameter(2, email);
			query.executeUpdate();
			transaction.commit();
			session.close();
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
    }    
    
    public Employee login(String email, String password)
    {
		Session session = ConnectionUtil.getSession();
    	Transaction transaction = null;
    	Employee employee = null;

    	try
    	{
    		transaction = session.getTransaction();
    		transaction.begin();
    		
    		@SuppressWarnings("unchecked")
    		Query<Employee> query = session.createQuery("From Employee where email = :email and password = :pass");
        	query.setParameter(1, email);
        	query.setParameter(2, password);
    		employee = (Employee)query.uniqueResult();
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
        return employee;
    }
    
    public Employee getEmployee(String userEmail)
    {
    	Session session = ConnectionUtil.getSession();
    	Transaction transaction = null;
    	Employee employee = null;
    	try
    	{
    		transaction = session.getTransaction();
    		transaction.begin();
    		
    		@SuppressWarnings("unchecked")
			Query<Employee> query = session.createQuery("FROM Employee WHERE id ='" + userEmail + "'");
    		employee = (Employee)query.uniqueResult();
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
		return employee;
    	
    }

    @SuppressWarnings("unchecked")
	public List<Employee> getEmployees()
    {
		List<Employee> employees = new ArrayList<Employee>();
		Session session = ConnectionUtil.getSession();
		Transaction transaction = null;
		
		try
		{
			transaction = session.getTransaction();
			transaction.begin();
			employees = session.createQuery("FROM Employee").list();
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
		return employees;
    }
}