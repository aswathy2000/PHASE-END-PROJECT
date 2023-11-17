<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@page errorPage="error.jsp" %>       
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Teacher</title>
</head>
<body>

<div style="text-align: center; margin: 30px">

		<h1><i>Add Teacher</i></h1>
		
		<br><br>
		
		<form action="addController" method="post">
		
				Teacher Name: 
				<br>
				<input type="text" name="teacherName">
				<br><br>
				
				Teacher Designation: 
				<br>
				<input type="text" name="teacherDesignation">
				<br><br>
				
		<input type="submit" value="		Add Teacher		"> 
		</form>

		</div>
		
		<div style="text-align: center; margin: 30px">

		<a href = teacherPage.jsp>Return to Teachers Main Page</a>

		</div>


</body>
</html>