package com.ex.ERS.DAOs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil 
{
	private static SessionFactory sessionFactory = new Configuration().configure("com/ex/ERS/Resources/hibernate.cfg.xml").buildSessionFactory();	
	public static Session getSession()
	{
		return sessionFactory.openSession();
	}
	
}
