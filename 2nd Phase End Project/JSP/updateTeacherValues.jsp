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
<title>Update Teacher Values</title>
</head>
<body>




<h3 style="text-align: center; color: red;"> Updated Teacher record '<%=request.getAttribute("TeacherName") %>' successfully ...</h3>

<%@include file = "teacherPage.jsp" %>

</body>
</html>