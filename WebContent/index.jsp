<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<link rel="stylesheet" type="text/css" href="/ERS/css/style.css">
<body>
	<div class="bootstrap-frm" id="page-wrap">
		<form action="login" method="post">
				<h1>Financial<br/>Reimbursement<br/>System</h1>
				<br/>
				<label>User Name:</label>
				<input name="uname" type="text" />
				<br/>
				<label>Password:</label>
				<input name="upass" type="password" />
				<br/>
				<label></label><input type="submit" value="Login"/>
		</form>
	</div>
</body>
</html>