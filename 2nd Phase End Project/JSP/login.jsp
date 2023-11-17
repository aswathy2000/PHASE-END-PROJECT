<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
  <%@page errorPage="error.jsp" %>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN LOGIN</title>
</head>
<body>


<div style="text-align: center; border: 2px solid black; margin: 30px 30px; padding: 20px">

		<br><br>

		<h1 style="color: midnight-blue"><b> Learner Academy </b></h1> 
		
		<br><br>
		
		<h2><b> Admin Login </b></h2>
		
		<br><br>
		
		<form action="ValidateUser" method ="post">
		
		Username: 
		<br><input type = "text" name = "username">
		<br><br>
		Password: 
		<br><input type = "password" name = "password">
		<br><br>
		<input type = "submit" name = "			Login 		">
		
		<br><br>
		
		
		
		
		</form>



</div>

</body>
</html>