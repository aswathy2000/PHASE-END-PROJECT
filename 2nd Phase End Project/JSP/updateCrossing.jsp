<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page errorPage="error.jsp" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Crossing</title>
</head>
<body>

		<style>
		input[type=text]
		{
		width: 280px;
		}
		
		pre{
		font-family: Times New Roman;
		}
		
		</style>
		
		<div style="text-align: center; margin: 30px">
		<br><h1 style="color: midnight-blue"><b> Railway Crossing </b></h1> 
		<h3 style="color: gray"><b> Update Railway Crossing Information </b></h3>
		</div>
		
		<div style="align-self: left; margin-left: 40%">
		
		<form action="updateController" method="post" style=" padding: 10px;">
				
				<input type="hidden" name="id" value="<%= request.getParameter("id") %>">
				
				Enter Name 
				<br>
				<input type="text" name="name" style=" width= 100%;">
				<br><br>
				
				Address 
				<br>
				<input type="text" name="address">
				<br><br>
				
				Landmark 
				<br>
				<input type="text" name="landmark">
				<br><br>
				
				Train Schedule
				<br>
				<input type="time" name="schedule">
				<br><br>
				
				Person In-charge 
				<br>
				<input type="text" name="person">
				<br><br>
				
				<pre>Crossing Status               Currently: OPEN</pre> 
				
				<input type="radio" name="status" value="OPEN"> OPEN <br>
				<input type="radio" name="status" value="CLOSED"> CLOSED
				<br><br>
				
				
				
		<br><input type="submit" value="Submit" style="background-color: green; border:none; border-radius:10px; color:white;  padding: 10px  122px">
		</form>

		</div>
		
		<div style="text-align: center; margin: 30px">

		<a href = adminHomePage.jsp>Return to Admin Home Page</a>

		</div>

</body>
</html>