<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
    <title>Employee List</title>    
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
	<script>
		<jsp:include page="tabs.js" /> 
    </script>
  </head>
  <body onload="init()">  
	<div class="bootstrap-frm" id="page-wrap">
		<h1 align="center">Financial <br/>Reimbursement System</h1>
		<p align ="center">Employee List</p>
	
				<table class="centered-table">
					<tr>
						<th>ID</th>
						<th>Title ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
					<c:forEach items="${allEmployees}" var="employees">
						<tr>
							<td><c:out value="${employees.id}" /></td>
							<td><c:out value="${employees.roleID}" /></td>
							<td><c:out value="${employees.firstname}" /></td>
							<td><c:out value="${employees.lastname}" /></td>
							<td><c:out value="${employees.email}" /></td>
						</tr>				
					</c:forEach>
				</table>
			</div>
</body>
</html>