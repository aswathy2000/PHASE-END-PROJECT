<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@page errorPage="error.jsp" %>       
<%@page import="com.project.dao.TeacherDAO"%>
<%@page import="com.project.pojo.Teacher"%>
<%@page import="java.util.*"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<div style="text-align: center; margin: 30px 30px">

		<br><br>

		
		<form action="addTeacher.jsp">
		
		
		<br><br>
		<input type = "submit" value = "			Add Teacher			">
		
		
		</form>
		
		<br><br>
		
		<br><br>
		
		<h3><i>List of Teachers </i></h3>
		
		
		<br><br>
		
		</div>
		
		<div>
		
		<div align="center">
		
		<table border="1" cellpadding="5" style="width:60%; border: 3px solid black ;border-collapse: collapse;">
		
		
		
		<tr >
			<th>Teacher Id</th>
			<th>Teacher Name</th>
			<th>Teacher Designation</th>
			<th>Edit </th>
			<th>Delete</th>
		</tr>
		
		
		<%
			TeacherDAO dao = new TeacherDAO();
			List<Teacher> teacherList = dao.displayTeacher();
			
			for(Teacher teacher : teacherList){
			%>
			<tr >
			<td><%=teacher.getTeacherId()%></td>
			<td><%=teacher.getTeacherName() %></td>
			<td><%=teacher.getTeacherDesignation() %></td>
			
			<td><a href="updateTeacher.jsp?id=<%=teacher.getTeacherId() %>"> Update </a></td>
			
			<td><a href="deleteTeacher.jsp?id=<%=teacher.getTeacherId()%>"> Delete </a></td>
			</tr>
			
			<%} %>
			
			</table>
			
			</div>
		
			<br><br>
			
			<div style="text-align: center; ">
		
			<a href = dashboard.jsp>Return to Dashboard</a>

			</div>

</div>

</body>
</html>