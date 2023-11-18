<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page errorPage="error.jsp" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>

		<div style="text-align: center; margin: 30px 30px; padding: 20px">
		<br><h1 style="color: midnight-blue"><b> Railway Crossing </b></h1> 
		
		<h3 style="color: gray"><b> Admin Login </b></h3>		
		<br><br>
		
		   <form action="adminValidate" method="post">
		       Enter Email :<br>
		       <input type="email" name="email" required><br><br>
		       Enter Password :<br>
		       <input type="password" name="password" required><br><br>
		       <br><br><input type="submit" value="Admin Login" style="background-color: green; border:none; border-radius:10px; color:white;  padding: 10px  80px">
		   </form>
		
		</div>
		
		<div style="text-align: center;">

		Don't have an account? <a href = registerUser.jsp> Create an account </a>

		</div>



</body>
</html>