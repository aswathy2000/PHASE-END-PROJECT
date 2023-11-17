<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.project.dao.StudentDAO"%>
<%@page import="com.project.pojo.Student"%>
<%@page import="java.util.*"%>

 <%@page errorPage="error.jsp" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Page</title>
</head>
<body>


<div style="text-align: center; margin: 30px">

		<br><br>
		<form action="addStudent.jsp">
		<br><br>
		<input type = "submit" value = "		Add Student		">		
		</form>		
		<br><br>				
		<h3><i>List of Students </i></h3>
		<br><br>		
		</div>		
		<div align="center">		
		<table border="1" cellpadding="5" style="width:60%; border: 3px solid black ;border-collapse: collapse;">		
		<tr >
			<th>Student Id</th>
			<th>Student Name</th>
			<th>Student Address</th>
			<th>Student Phone Number</th>
			<th>Student DOB</th>
			<th>Student Class</th>
			
			<th>Edit </th>
			<th>Delete</th>
		</tr>
		
		
		<%
			StudentDAO dao = new StudentDAO();
			List<Student> studentList = dao.displayStudent();
			
			for(Student student : studentList){
			%>
			<tr >
			<td><%=student.getStudentId()%></td>
			<td><%=student.getStudentName()%></td>
			<td><%=student.getStudentAddress() %></td>
			<td><%=student.getStudentPhoneNo() %></td>
			<td><%=student.getStudentDOB() %></td>
			<td><%=student.getClasses().getClassName() %></td>
			
			
			<td><a href="updateStudent.jsp?id=<%=student.getStudentId() %>"> Update </a></td>
			
			<td><a href="deleteStudent.jsp?id=<%=student.getStudentId()%>"> Delete </a></td>
			</tr>
			
			<%} %>
			
			
		</table>
		
		</div>
		
		<br><br>
		
		<div style="text-align: center; margin: 30px">

		<a href = dashboard.jsp>Return to Dashboard</a>

		</div>

</body>
</html>