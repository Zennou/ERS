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
	<div class="bootstrap-frm" id="page-wrap" style="width:800px;">	
				<h1>Financial<br/>Reimbursement<br/>System</h1></br>
		<div id="centeredmenu">
			<ul class="tab" width="400px">
				<li><a href="#" class="tablinks" onclick="openCity(event, 'pending')">Pending</a></li>
				<li><a href="#" class="tablinks" onclick="openCity(event, 'approved')">Approved</a></li>
				<li><a href="#" class="tablinks" onclick="openCity(event, 'denied')">Denied</a></li>
				<li><a href="#" class="tablinks" onclick="openCity(event, 'newRei')">Create New</a></li>
			</ul>
		</div>

		<div class="tabcontent" id="pending">
			<h2>Pending Reimbursements</h2>
			<table cellpadding="10" class="centered-table">
				<tr>
					<th>ID</th>
					<th>Author ID</th>
					<th>Resolver ID</th>
					<th>Type ID</th>
					<th>Created On</th>
					<th>Modified On</th>
					<th>Description</th>
					<th>Amount</th>
				</tr>
				<c:forEach items="${pending}" var="reimbursement" varStatus="status">
					<tr>
						<td><c:out value="${reimbursement.id}" /></td>
						<td><c:out value="${reimbursement.authorID}" /></td>
						<td><c:out value="${reimbursement.resolverID}" /></td>
						<td><c:out value="${reimbursement.typeID}" /></td>
						<td><c:out value="${reimbursement.createdDate}" /></td>
						<td><c:out value="${reimbursement.modifiedDate}" /></td>
						<td><c:out value="${reimbursement.description}" /></td>
						<td><c:out value="${reimbursement.amount}" /></td>
					</tr>				
				</c:forEach>
			</table>
		</div>

		<div class="tabcontent" id="approved">
		  <h2>Approved Reimbursements</h2>
				<table cellpadding="10" class="centered-table">
					<tr>
					<th>ID</th>
					<th>Author ID</th>
					<th>Resolver ID</th>
					<th>Type ID</th>
					<th>Created On</th>
					<th>Modified On</th>
					<th>Description</th>
					<th>Amount</th>
					</tr>
					<c:forEach items="${approved}" var="reimbursement" varStatus="status">
						<tr>
							<td><c:out value="${reimbursement.id}" /></td>
							<td><c:out value="${reimbursement.authorID}" /></td>
							<td><c:out value="${reimbursement.resolverID}" /></td>
							<td><c:out value="${reimbursement.typeID}" /></td>
							<td><c:out value="${reimbursement.createdDate}" /></td>
							<td><c:out value="${reimbursement.modifiedDate}" /></td>
							<td><c:out value="${reimbursement.description}" /></td>
							<td><c:out value="${reimbursement.amount}" /></td>
						</tr>				
					</c:forEach>
				</table>
		</div>

		<div class="tabcontent" id="denied">
		  <h2>Denied Reimbursements</h2>
				<table cellpadding="10" class="centered-table">
					<tr>
					<th>ID</th>
					<th>Author ID</th>
					<th>Resolver ID</th>
					<th>Type ID</th>
					<th>Created On</th>
					<th>Modified On</th>
					<th>Description</th>
					<th>Amount</th>
					</tr>
					<c:forEach items="${denied}" var="reimbursement" varStatus="status">
						<tr>
							<td><c:out value="${reimbursement.id}" /></td>
							<td><c:out value="${reimbursement.authorID}" /></td>
							<td><c:out value="${reimbursement.resolverID}" /></td>
							<td><c:out value="${reimbursement.typeID}" /></td>
							<td><c:out value="${reimbursement.createdDate}" /></td>
							<td><c:out value="${reimbursement.modifiedDate}" /></td>
							<td><c:out value="${reimbursement.description}" /></td>
							<td><c:out value="${reimbursement.amount}" /></td>
						</tr>					
					</c:forEach>
				</table>
		</div>
	    	
	    	<div class="tabcontent" id="newRei">
		    	<form action="create_reimbursement" method="post">
					<div class="menu">
						<label for="reiType" style="display:">Type:</label>
						<select name="reiType" style="width:100px;">
								<option value="Food">Food</option>
								<option value="Travel">Travel</option>
								<option value="Supplies">Supplies</option>
								<option value="Medical">Medical</option>
								<option value="Misc">Other</option>
						</select>
						<br/>
						<label for="reiAmount" style="display:">Amount:</label>
						<input name="reiAmount" type="text" style="width:34%;"/>
						<br/>
						<label for="reiDescription" style="display:">Description:</label>
						<input name="reiDescription" type="text" style="width:34%;"/>
						<br/>
						<input type="submit" value="Submit Request"/>
					</div>
				</form>
			</div>
			<p><a href="home.jsp">Return to the Home Page</a></p>
	</div>
  </body>
</html>
