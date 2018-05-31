package com.ex.ERS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employee
{
   @Id 
   @GeneratedValue
   @Column(name = "Employee_ID")
   private int id;

   @Column(name = "Role_ID")
   private int roleID;

   @Column(name = "Email")
   private String email;

   @Column(name = "Password")
   private String password;

   @Column(name = "First_Name")
   private String firstname;

   @Column(name = "Last_Name")
   private String lastname;

   	public int getID()
	{
		return id;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
	
	public int getRoleID()
	{
		return roleID;
	}
	
	public void setRoleID(int roleID)
	{
		this.roleID = roleID;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getFirstname()
	{
		return firstname;
	}
	
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	
	public String getLastname()
	{
		return lastname;
	}
	
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
}
