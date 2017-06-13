<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.ex.ERS.Employee"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<link rel="stylesheet" type="text/css" href="/ERS/css/style.css">
<body>
	<div class="bootstrap-frm" id="page-wrap">
		<h1>Financial<br/>Reimbursement<br/>System</h1>
		<p>Welcome, <c:out value='${sessionFirstName}' /></p>
		<p><a href="user_requests">View All Requests</a></p>
		<p><a href="employee_list">View Employees</a></p>
		<p><a href="logout">Logout</a></p>
	</div>
</body>
</html>