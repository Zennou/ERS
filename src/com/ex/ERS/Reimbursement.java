package com.ex.ERS;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Reimbursements")
public class Reimbursement
{
	@Id 
	@GeneratedValue
	@Column(name = "Reimbursement_ID")
	private int id;

	@Column(name = "Author_ID")
	private int authorID;
	
	@Column(name = "Resolver_ID")
	private int resolverID;

	@Column(name = "Type_ID")
	private int typeID;
	
	@Column(name = "Status_ID")
	private int statusID;

	@Column(name = "Created_Date")
	private Date createdDate;

	@Column(name = "Update_Date")
	private Date modifiedDate;

	@Column(name = "Amount")
	private double amount;

	@Column(name = "Description")
	private String description;

	@Column(name = "Reciept")
	private Blob reciept;
	
	public int getId(){return id;}
	public void setId(int id){this.id = id;}
	public int getAuthorID(){return authorID;}
	public void setAuthorID(int authorID){this.authorID = authorID;}
	public int getResolverID(){return resolverID;}
	public void setResolverID(int resolverID){this.resolverID = resolverID;}
	public int getTypeID(){return typeID;}
	public void setTypeID(int typeID){this.typeID = typeID;}
	public int getStatusID(){return statusID;}
	public void setStatusID(int statusID){this.statusID = statusID;}
	public Date getCreatedDate(){return createdDate;}
	public void setCreatedDate(Date createdDate){this.createdDate = createdDate;}
	public Date getModifiedDate(){return modifiedDate;}
	public void setModifiedDate(Date modifiedDate){this.modifiedDate = modifiedDate;}
	public double getAmount(){return amount;}
	public void setAmount(double amount){this.amount = amount;}
	public String getDescription(){return description;}
	public void setDescription(String description){this.description = description;}
	public Blob getReciept(){return reciept;}
	public void setReciept(Blob reciept){this.reciept = reciept;}
}
