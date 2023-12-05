<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body>
		
	<div style="margin:25px; padding: 20px; border: 3px solid black; width: 30%">
		<h3> Login </h3>
		<form action="login">
		       Username: 
		       <input type="text" id="username" name="username"><br><br>
		      
		       Password:
		       <input type="password" id="password" name="password"><br><br>
		      
		       <input type="submit" value="Login">
		       </form>
		       <br>
		       <form action="registration.jsp" method ="get">
		       <input type="submit" value="Registeration" >
		       </form>	       
	</div>	
	
	<br>
	<div>
	<footer style="margin:35px; padding: 20px; "><b>Developer: Aswathy P K</b></footer>
	</div>	

</body>
</html>