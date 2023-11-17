<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@page errorPage="error.jsp" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FAILED TO LOGIN</title>
</head>
<body>

		<div style="text-align: center; margin: 30px; color: red;">
		<b>
		
		<%out.print(" FAILED TO LOGIN!!! Please try again..."); %>
		</b>
		</div>

		<%@include file = "login.jsp" %>

</body>
</html>