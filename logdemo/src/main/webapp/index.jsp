<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Demo Application</title>
</head>
<body>
	<center>
		<h1>Login Demo Application</h1>
		<form action = "/login">	
				Username :<input type ="text" name = "name"><br><br>
				Password :<input type="password" name="pass"><br><br>
			<input type = "submit" value = "Login">
		</form>
		
		<br><br><br>
		
		<a href = "register.jsp">Register</a>
	
	</center>
</body>
</html>