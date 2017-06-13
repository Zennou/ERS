<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
	<title>Reimbursements</title>
	<link rel="stylesheet" type="text/css" href="/ERS/css/style.css"/>
	<script>
		<jsp:include page="tabs.js" /> 
    </script>
	<style>tr{align: justify;}</style>
</head>
<body>
	<div class="bootstrap-frm" id="page-wrap">
		<h1 align="center">Financial <br/>Reimbursement System</h1>
    	
		
		<div id="centeredmenu">
			<ul class="tab" >
				<li><a href="#" class="tablinks" onclick="openCity(event, 'empInfo')">Employee Information</a></li>
				<li><a href="#" class="tablinks" onclick="openCity(event, 'empUpdate')">Update Information</a></li>
			</ul>
    	</div>
    	
    	<div class="tabcontent" id="empInfo" align="center">
	    	<table>
				<c:forEach items="${employeeList}" var="employee">
						<tr align="center"><td>Employee ID: <c:out value="${employee.id}" /></td></tr>
						<tr align="center"><td>Name: <c:out value="${employee.firstname} ${employees.lastname}" /></td></tr>
						<tr align="center"><td>Email: <c:out value="${employee.email}" /></td></tr>
				</c:forEach>
			</table>
		</div>
    	
    	<div class="tabcontent" id="empUpdate">
	    	<form action="update_employee" method="post">
				<div class="menu">
					<label for="empFirstName" style="display:">First Name:</label>
					<input name="empFirstName" type="text" style="width:34%;"/>
					<br/>
					<label for="empLastName" style="display:">Last Name: </label>
					<input name="empLastName" type="text" style="width:34%;"/>
					<br/>
					<label for="empPassword" style="display:">Password: </label>
					<input name="empPassword" type="password" style="width:34%;"/>
					<br/>
					<input type="submit" value="Submit"/>
				</div>
			</form>
		</div>
	<p><a href="home.jsp">Return to the Home Page</a></p>
</div>
</body>
</html>