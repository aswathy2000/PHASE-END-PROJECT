<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@page errorPage="error.jsp" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Class</title>
</head>
<body>

<div style="text-align: center; margin: 30px">

		<h1><i>Update Class for Class-ID : <%= request.getParameter("id") %></i></h1>
		
		<br><br>
		
		<form action="updateClass" method="post">
		
				<input type="hidden" name="id" value="<%= request.getParameter("id") %>">
		
				Class Name: 
				<br>
				<input type="text" name="className">
				<br><br>
				
				
				
		<input type="submit" value="		Update Class		"> 
		</form>

		</div>

		<div style="text-align: center; margin: 30px">

		<a href = dashboard.jsp>Return to Main Page</a>

		</div>


</body>
</html>