<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page errorPage="error.jsp" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Failed</title>
</head>
<body>


		<div style="text-align: center; margin: 30px">
		
		<%out.print(" FAILED operation... Please try again..."); %>
		
		</div>
		
		<%@include file = "registerUser.jsp" %>


</body>
</html>