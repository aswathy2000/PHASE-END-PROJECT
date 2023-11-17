<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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

 <%@page errorPage="error.jsp" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Subject and Teacher for a Class</title>
</head>
<body>

		<div style="text-align: center; margin: 30px">

		<h1><i>Assign Teacher and Subject for <%=request.getParameter("name") %> </i></h1>
		
		<br><br>
		
		<form action="assignTeacherSubjectController" method="post">
		
		<input type="hidden" name="cname" value="<%= request.getParameter("name") %>">
		
				Select Teacher : 
				<br>
				<select name="teacherClass">
					<% 
					TeacherDAO daoT = new TeacherDAO();
					Teacher teacher = new Teacher();
					List<Teacher> listTeachers = daoT.displayTeacher();
					Set<String> nameOfTeacher = new HashSet<String>();
					for(Teacher t: listTeachers)
					{
						nameOfTeacher.add(t.getTeacherName());
					}
					
					for(String teacherNames : nameOfTeacher)
					{%>
				
					<option value="<%=teacherNames %>"> <%=teacherNames %> </option>
				
					<% } %>
				
				</select>
				<br><br>
				
				Select Subject : 
				<br>
				<select name="subjectClass">
					<% 
					SubjectDAO daoS = new SubjectDAO();
					Subject subject = new Subject();
					List<Subject> listSubjects = daoS.displaySubject();
					Set<String> nameOfSubject = new HashSet<String>();
					for(Subject s: listSubjects)
					{
						nameOfSubject.add(s.getSubjectName());
					}
					
					for(String subjectName : nameOfSubject)
					{%>
				
					<option value="<%=subjectName %>"> <%=subjectName %> </option>
				
					<% } %>
				
				</select>
				<br><br>
				
		<input type="submit" value="		Assign		"> 
		</form>
		
		</div>
		

		

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
		
		<%
		   String className = request.getParameter("name");
		  
		   ClassDAO classDAO = new ClassDAO();
		   List<Classes> classesList = classDAO.getClassesByName(className);
		   if (classesList != null && !classesList.isEmpty()) {
		       Classes classData = classesList.get(0);
		       
		       TeacherDAO teacherDAO = new TeacherDAO();
		       Teacher teacher1 = teacherDAO.getTeacherById(classData.getTeacher().getTeacherId());
		       SubjectDAO subjectDAO = new SubjectDAO();
		       Subject subject1 = subjectDAO.getSubjectById(classData.getSubject().getSubjectId());
		%>
		
		
		<tr >		
			<tr >
			<td><%= classData.getClassId() %></td>
			<td><%= classData.getClassName() %></td>
			<td><%= teacher1.getTeacherName() %></td>
      		<td><%= subject1.getSubjectName() %></td>

			</tr>
			
		</table>
		
		<% } else { %>
   		<p>No data found for this class name.</p>
		<% } %>
		
		</div>
		
		<div style="text-align: center; margin: 30px">

		<a href = dashboard.jsp>Return to Main Page</a>

		</div>



</body>
</html>