<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@page errorPage="error.jsp" %>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Subject</title>
</head>
<body>

<div style="text-align: center; margin: 30px">

		<h1><i>Add Subject</i></h1>
		
		<br><br>
		
		<form action="addSubjectController" method="post">
		
				Subject Name: 
				<br>
				<input type="text" name="subjectName">
				<br><br>
				
				
				
		<input type="submit" value="		Add Subject		"> 
		</form>
		
		<div style="text-align: center; margin: 30px">

		<a href = subjectPage.jsp>Return to Subjects Main Page</a>

		</div>

</div>

</body>
</html>