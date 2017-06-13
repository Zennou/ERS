<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.ex.ERS.Employee"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<link rel="stylesheet" type="text/css" href="/ERS/css/style.css">	
      <body>
      	<div id="page-wrap">
			<h1 align="center">Financial</h1>
			<h1 align="center">Reimbursement System</h1>
	         <p align="center"><c:out value="${sessionError}" /></p>
			<p align="center"><a href="home.jsp">Return to Home Page</a></p>
		</div>
	</body>
   </html>