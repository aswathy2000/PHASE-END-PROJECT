<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@page errorPage="error.jsp" %>       
    
<%@page import="com.project.pojo.Teacher"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Teacher</title>
</head>
<body>






<div style="text-align: center; margin: 30px">

		<h1><i>Update Teacher for Teacher-ID : <%= request.getParameter("id") %></i></h1>
		
		<br><br>
		
		<form action="updateTeacher" method="post">
		
				<input type="hidden" name="id" value="<%= request.getParameter("id") %>">
		
				Teacher Name: 
				<br>
				<input type="text" name="teachername">
				<br><br>
				
				Teacher Designation: 
				<br>
				<input type="text" name="teacherdesignation">
				<br><br>
				
		<input type="submit" value="		Update Teacher		"> 
		</form>

		</div>
		
		
		<div style="text-align: center; margin: 30px ">

		<a href = teacherPage.jsp>Return to Teachers Main Page</a>

		</div>


</body>
</html>