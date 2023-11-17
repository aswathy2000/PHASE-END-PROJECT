<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.project.dao.TeacherDAO"%>
<%@page import="com.project.pojo.Teacher"%>
<%@page import="java.util.*"%>

 <%@page errorPage="error.jsp" %>   


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Teacher</title>
</head>
<body>

<%

TeacherDAO dao1 = new TeacherDAO();
Teacher teacher1 = new Teacher();


teacher1.setTeacherId(Integer.parseInt(request.getParameter("id")));
List<Teacher> listTeacher = dao1.deleteTeacher(teacher1);


%>


<h3 style="text-align: center; color: red;"> Deleted Teacher record for Teacher-Id :  <%=request.getParameter("id") %> , successfully...</h3>

<%@include file = "teacherPage.jsp" %>

</body>
</html>