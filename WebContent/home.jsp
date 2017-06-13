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
		<h1><strong>Financial<br/>Reimbursement<br/>System</strong></h1>
		<p>Welcome, <c:out value='${sessionFirstName}' /></p>
		<p align="center" ><a class="link" href="reimbursements">Reimbursements</a></p>
		<p align="center"><a class="link" href="employee_info">Employee Info</a></p>
		<p align="center"><a class="link" href="logout">Logout</a></p>
	</div>
</body>
</html>