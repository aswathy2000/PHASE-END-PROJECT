<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>

 <%@page import="com.example.demo.pojo.*" %>
 <%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

<style>

	table, th, td {
  border: 1px solid black;
}

</style>

<div style="margin:25px; padding: 20px;">
<table border="1" style="text-align: center">
	<tr>
		<td><a href="getallcitizen"> Citizens </a></td>
		
		<td><form action="getall"><a href="getall"> Vaccination Centers </a></form></td>
		<td><a href="logout.jsp"> Logout </a></td>
		<td><a href="#"> Welcome, admin </a></td>
	</tr>
</table>

</div>



</body>
</html>