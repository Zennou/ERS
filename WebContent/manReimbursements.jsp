<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
    <title>Reimbursement Requests</title>    
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
	<script>
		<jsp:include page="tabs.js" /> 
    </script>
  </head>
  <body onload="init()">  
		<h1 align="center">Financial</h1>
		<h1 align="center">Reimbursement System</h1>
		<p align="center">Reimbursement Requests</p>
		
	<div align="center">
		<div id="centeredmenu">
			<ul class="tab">
				<li><a href="#" class="tablinks" onclick="openCity(event, 'pending')">Pending</a></li>
				<li><a href="#" class="tablinks" onclick="openCity(event, 'approved')">Approved</a></li>
				<li><a href="#" class="tablinks" onclick="openCity(event, 'denied')">Denied</a></li>
			</ul>
		</div>

		<div class="tabcontent" id="pending" style="width:70%;">
			<h2>Pending Reimbursements</h2>
			<table cellpadding="10" class="centered-table">
				<tr>
					<th>ID</th>
					<th>Author ID</th>
					<th>Resolver ID</th>
					<th>Type ID</th>
					<th>Status ID</th>
					<th>Created Date</th>
					<th>Modified date</th>
					<th>Amount</th>
				</tr>
				<c:forEach items="${pending}" var="reimbursement" varStatus="status">
					<tr>
						<td><c:out value="${reimbursement.id}" /></td>
						<td><c:out value="${reimbursement.authorID}" /></td>
						<td><c:out value="${reimbursement.resolverID}" /></td>
						<td><c:out value="${reimbursement.typeID}" /></td>
						<td><c:out value="${reimbursement.statusID}" /></td>
						<td><c:out value="${reimbursement.createdDate}" /></td>
						<td><c:out value="${reimbursement.modifiedDate}" /></td>
						<td><c:out value="${reimbursement.amount}" /></td>
					</tr>				
				</c:forEach>
			</table>
		</div>

		<div class="tabcontent" id="approved" style="width:70%;">
		  <h2>Approved Reimbursements</h2>
				<table cellpadding="10" class="centered-table">
				<tr>
					<th>ID</th>
					<th>Author ID</th>
					<th>Resolver ID</th>
					<th>Type ID</th>
					<th>Status ID</th>
					<th>Created Date</th>
					<th>Modified date</th>
					<th>Amount</th>
				</tr>
					<c:forEach items="${approved}" var="reimbursement" varStatus="status">
							<tr>
						<td><c:out value="${reimbursement.id}" /></td>
						<td><c:out value="${reimbursement.authorID}" /></td>
						<td><c:out value="${reimbursement.resolverID}" /></td>
						<td><c:out value="${reimbursement.typeID}" /></td>
						<td><c:out value="${reimbursement.statusID}" /></td>
						<td><c:out value="${reimbursement.createdDate}" /></td>
						<td><c:out value="${reimbursement.modifiedDate}" /></td>
						<td><c:out value="${reimbursement.amount}" /></td>
							</tr>				
					</c:forEach>
				</table>
		</div>

		<div class="tabcontent" id="denied" style="width:70%;">
		  <h2>Denied Reimbursements</h2>
				<table cellpadding="10" class="centered-table">
					<tr>
					<th>ID</th>
					<th>Author ID</th>
					<th>Resolver ID</th>
					<th>Type ID</th>
					<th>Status ID</th>
					<th>Created Date</th>
					<th>Modified date</th>
					<th>Amount</th>
					</tr>
					<c:forEach items="${denied}" var="reimbursement">
							<tr>
								<td><c:out value="${reimbursement.id}" /></td>
								<td><c:out value="${reimbursement.authorID}" /></td>
								<td><c:out value="${reimbursement.resolverID}" /></td>
								<td><c:out value="${reimbursement.typeID}" /></td>
								<td><c:out value="${reimbursement.statusID}" /></td>
								<td><c:out value="${reimbursement.createdDate}" /></td>
								<td><c:out value="${reimbursement.modifiedDate}" /></td>
								<td><c:out value="${reimbursement.amount}" /></td>
							</tr>				
					</c:forEach>
				</table>
		</div>
			<p><a href="home.jsp">Return to the Home Page</a></p>
	</div>
</body>
</html>