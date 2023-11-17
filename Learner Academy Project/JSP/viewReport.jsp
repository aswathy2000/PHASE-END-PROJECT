<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@page errorPage="error.jsp" %>   

<%@page import="com.project.dao.StudentDAO"%>
<%@page import="com.project.dao.ClassSubjectTeacherDAO"%>
<%@page import="com.project.pojo.Student"%>
<%@page import="com.project.dao.ClassDAO"%>
<%@page import="com.project.pojo.Classes"%>
<%@page import="com.project.dao.TeacherDAO"%>
<%@page import="com.project.pojo.Teacher"%>
<%@page import="com.project.dao.SubjectDAO"%>
<%@page import="com.project.pojo.Subject"%>

<%@page import="java.util.*"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Report</title>
</head>
<body>

		<%
		   String className = request.getParameter("name");
		  
		   ClassDAO classDAO = new ClassDAO();
		   List<Classes> classesList = classDAO.getClassesByName(className);
		   if (classesList != null && !classesList.isEmpty()) {
		       Classes classData = classesList.get(0);
		       
		       TeacherDAO teacherDAO = new TeacherDAO();
		       Teacher teacher = teacherDAO.getTeacherById(classData.getTeacher().getTeacherId());
		       SubjectDAO subjectDAO = new SubjectDAO();
		       Subject subject = subjectDAO.getSubjectById(classData.getSubject().getSubjectId());
		%>
		
		<br><br>

		<div style="text-align: center; margin: 30px">

							
		<h3><i> View Teacher and Subject for <%=request.getParameter("name") %> </i></h3>
				
		</div>	
		
		<div align="center">		
		<table border="1" cellpadding="5" style="width:60%; border: 3px solid black ;border-collapse: collapse;">		
		<tr >
			<th>Class Id</th>
			<th>Class Name</th>
			<th>Subject Name</th>
			<th>Teacher Name</th>

			
		</tr>
		
		<tr >
		
			<tr >
			<td><%= classData.getClassId() %></td>
			<td><%= classData.getClassName() %></td>
			<td><%= teacher.getTeacherName() %></td>
      		<td><%= subject.getSubjectName() %></td>

			</tr>
			
		</table>
		
		<% } else { %>
   		<p>No data found for this class name.</p>
		<% } %>
		
		</div>
		
		<br><br>
		
		<div style="text-align: center; margin: 30px">

							
		<h3><i> View Students for <%=request.getParameter("name") %> </i></h3>
				
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
			
		</tr>
		
		
		<%
			StudentDAO dao = new StudentDAO();
			List<Student> studentList = dao.displayStudent();
			
			for(Student student : studentList){
				if((student.getClasses().getClassName()).equals(request.getParameter("name")))
			{%>
			<tr >
			<td><%=student.getStudentId()%></td>
			<td><%=student.getStudentName()%></td>
			<td><%=student.getStudentAddress() %></td>
			<td><%=student.getStudentPhoneNo() %></td>
			<td><%=student.getStudentDOB() %></td>
			<td><%=student.getClasses().getClassName() %></td>
			
			</tr>
			
			<%}  
			}%>
			
			
		</table>
		
		</div>
		
		<br><br>
		
		<div style="text-align: center; margin: 30px">

		<a href = dashboard.jsp>Return to Dashboard</a>

		</div>
		

</body>
</html>