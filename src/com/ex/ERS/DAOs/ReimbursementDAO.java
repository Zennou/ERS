package com.ex.ERS.DAOs;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ex.ERS.Reimbursement;

public class ReimbursementDAO
{    
    public void addReimbursement(int authID, int typeID, double amount, String description)
    {
		Session session = ConnectionUtil.getSession();
		session.beginTransaction();
		Reimbursement reimbursement = new Reimbursement();
		
		try
		{
			reimbursement.setAuthorID(authID);
			reimbursement.setTypeID(typeID);
			reimbursement.setAmount(amount);
			reimbursement.setDescription(description);
			
			session.save(reimbursement);
			session.getTransaction().commit();
		}		
		catch(Exception e)
		{
			if(session.getTransaction() != null)
			{
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
    }
    
    public void updateReimbursement(int reiID, int statusID)
    {
    	Session session = ConnectionUtil.getSession();
    	Transaction transaction = session.beginTransaction();
    	@SuppressWarnings("unchecked")
		Query<Reimbursement> query = session.createQuery("UPDATE Reimbursement set statusID = :status WHERE id = :id");
    	query.setParameter("id", reiID);
    	query.setParameter("status", statusID);
		query.executeUpdate();
		
		transaction.commit();
		session.close();    	
    }
    
    @SuppressWarnings("unchecked")
	public List<Reimbursement> getReimbursements()
    {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
    	Session session = ConnectionUtil.getSession();
    	Transaction transaction = null;
    	try
    	{
    		transaction = session.getTransaction();
    		transaction.begin();
    		reimbursements = session.createQuery("FROM Reimbursement").list();
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
		return reimbursements;
    }

    @SuppressWarnings("unchecked")
	public List<Reimbursement> getReimbursementsByUser(String userEmail)
    {
        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		Session session = ConnectionUtil.getSession();
		Transaction transaction = null;
		
		try
		{
			transaction = session.getTransaction();
			transaction.begin();
			reimbursements = session.createQuery("FROM Employee WHERE email ='" + userEmail + "'").list();
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
        return reimbursements;
    }
}