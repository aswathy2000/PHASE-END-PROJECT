<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page errorPage="error.jsp" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Subject</title>
</head>
<body>


<div style="text-align: center; margin: 30px">

		<h1><i>Update Subject for Subject-ID : <%= request.getParameter("id") %></i></h1>
		
		<br><br>
		
		<form action="updateSubject" method="post">
		
				<input type="hidden" name="id" value="<%= request.getParameter("id") %>">
		
				Subject Name: 
				<br>
				<input type="text" name="subjectName">
				<br><br>
				
		<input type="submit" value="		Update Subject		"> 
		</form>

		</div>

		<div style="text-align: center; margin: 30px">

		<a href = subjectPage.jsp>Return to Subjects Main Page</a>

		</div>


</body>
</html>