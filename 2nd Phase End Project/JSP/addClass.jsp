<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@page errorPage="error.jsp" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Class</title>
</head>
<body>


<div style="text-align: center; margin: 30px">

		<h1><i>Add Class</i></h1>
		
		<br><br>
		
		<form action="addClassController" method="post">
		
				Class Name: 
				<br>
				<input type="text" name="className">
				<br><br>
				
				
				
		<input type="submit" value="		Add Class		"> 
		</form>
		
		<div style="text-align: center; margin: 30px">

		<a href = dashboard.jsp>Return to Main Page</a>

		</div>

</div>

</body>
</html>