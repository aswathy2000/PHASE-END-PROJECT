<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.project.dao.StudentDAO"%>
<%@page import="com.project.pojo.Student"%>

<%@page import="com.project.dao.ClassDAO"%>
<%@page import="com.project.pojo.Classes"%>

<%@page import="java.util.*"%> 

 <%@page errorPage="error.jsp" %>       
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student Form</title>
</head>
<body>


<div style="text-align: center; margin: 30px">

		<h1><i>Update Student for Student-ID : <%= request.getParameter("id") %></i></h1>
		
		<br><br>
		
		<form action="updateStudent" method="post">
		
				<input type="hidden" name="studentId" value="<%= request.getParameter("id") %>">
		
				Student Name: 
				<br>
				<input type="text" name="studentName">
				<br><br>
				Student Address: 
				<br>
				<input type="text" name="studentAddress">
				<br><br>
				Student Phone number: 
				<br>
				<input type="text" name="studentPhoneNo">
				<br><br>
				Student DOB: 
				<br>
				<input type="date" name="studentDOB">
				<br><br>
				
				
				Student Class: 
				<br>
				<select name="studentClass">
					<% 
					
					ClassDAO dao = new ClassDAO();
					Classes classes = new Classes();
					
					List<Classes> listClasses = dao.displayClasses();
					
					Set<String> nameOfClass = new HashSet<String>();
					for(Classes c: listClasses)
					{
						nameOfClass.add(c.getClassName());
					}
					
					for(String classNames : nameOfClass)
					{%>
				
					<option value="<%=classNames %>"> <%=classNames %> </option>
				
					<% } %>
				
				</select>
				
				
				<br><br>
				
				
		<input type="submit" value="		Update Student		"> 
		</form>

		</div>

		<div style="text-align: center; margin: 30px">

		<a href = studentPage.jsp>Return to Students Main Page</a>

		</div>

</body>
</html>