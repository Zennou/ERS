<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
    <title>Reimbursement Requests</title>
	<link rel="stylesheet" type="text/css" href="/ERS/css/style.css"/>   
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Reimbursement Request Form</title>
</head>
<body>
	<script>
		<jsp:include page="tabs.js" /> 
    </script>
	<div class="header">
		<h1>New Employee Information</h1>
	</div>
	<form action="create_reimbursement" method="post">
		<div class="menu">
			<label for="reiType" style="display:">Type:</label>
			<select id="reiType">
				<c:forEach items="${types}" var="type">
					<option value="${type.id}1">${type.name}</option>
				</c:forEach>
			</select>
			<br/>
			<label for="reiAmount">Amount:</label>
			<input name="reiAmount" type="password" />
			<br/>
			<input type="submit" value="Submit Request"/>
		</div>
	</form>
</body>
</html>