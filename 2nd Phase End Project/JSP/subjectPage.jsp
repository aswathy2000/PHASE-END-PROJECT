<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.project.dao.SubjectDAO"%>
<%@page import="com.project.pojo.Subject"%>
<%@page import="java.util.*"%>

 <%@page errorPage="error.jsp" %>   

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject Page</title>
</head>
<body>


		<div style="text-align: center; margin: 30px">

		<br><br>

		
		<form action="addSubject.jsp">
		
		
		<br><br>
		<input type = "submit" value = "			Add Subject			">
		
		</form>
		
		<br><br>
		
		<br><br>
		
		<h3><i>List of Subjects </i></h3>
		
		
		<br><br>
		
		</div>
		
		<div align="center">
		
		<table border="1" cellpadding="5" style="width:60%; border: 3px solid black ;border-collapse: collapse;">
		
		
		
		<tr >
			<th>Subject Id</th>
			<th>Subject Name</th>
			
			<th>Edit </th>
			<th>Delete</th>
		</tr>
		
		
		<%
			SubjectDAO dao = new SubjectDAO();
			List<Subject> subjectList = dao.displaySubject();
			
			for(Subject subject : subjectList){
			%>
			<tr >
			<td><%=subject.getSubjectId()%></td>
			<td><%=subject.getSubjectName() %></td>
			
			
			<td><a href="updateSubject.jsp?id=<%=subject.getSubjectId() %>"> Update </a></td>
			
			<td><a href="deleteSubject.jsp?id=<%=subject.getSubjectId()%>"> Delete </a></td>
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