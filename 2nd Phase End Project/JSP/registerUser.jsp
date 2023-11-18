<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page errorPage="error.jsp" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>

		<div style="text-align: center; margin: 30px 30px; padding: 20px">
		<br><h1 style="color: midnight-blue"><b> Railway Crossing </b></h1> 
		
		<h3 style="color: gray"><b> User Register </b></h3>		
		<br><br>
		
		<form action="RegisterNewUser" method ="post" >		
		Enter Name: 
		<br><input type = "text" name = "username" required><br><br>
		Enter Email: 
		<br><input type = "text" name = "email" required><br><br>		
		Password: 
		<br><input type = "password" name = "password" required><br><br>
		<input type = "submit" name = "			Register		"  style="background-color: green; border:none; border-radius:10px; color:white;  padding: 10px  100px">
		<br><br>
		</form>
		
		<div style="text-align: center; margin: 20px;">

		Already have account? <a href = login.jsp> Sign In Instead </a>

		</div>
		
		<div style="text-align: center; margin: 20px;">

		Sign in as Admin <a href = adminLogin.jsp> Admin Login </a>

		</div>
		<br><br>

		<footer style="color: gray"><p>Developer: Aswathy P K</p></footer>

</div>
		
</body>
</html>