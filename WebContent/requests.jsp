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
		<p align="center">Enter the user name of</p>
		<form action="user_requests" method="post">
			
		</form>
  </body>
</html>
