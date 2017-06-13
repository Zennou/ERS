package com.ex.ERS;

import java.sql.Blob;
import java.util.Date;

public class Reimbursement
{
	private int id, authorID, resolverID, typeID, statusID;
	private Date createdDate, modifiedDate;
	private double amount;
	private String description, authorName, resolverName, typeName, statusName;
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
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getResolverName() {
		return resolverName;
	}
	public void setResolverName(String resolverName) {
		this.resolverName = resolverName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public Blob getReciept(){return reciept;}
	public void setReciept(Blob reciept){this.reciept = reciept;}
}
