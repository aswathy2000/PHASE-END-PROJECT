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
<title>Insert title here</title>
</head>
<body>

<%

StudentDAO dao1 = new StudentDAO();
Student student1 = new Student();


student1.setStudentId((Integer.parseInt(request.getParameter("id"))));
List<Student> listStudent = dao1.deleteStudent(student1);


%>


<h3 style="text-align: center; color: red;"> Deleted Student record for Student-Id :  <%=request.getParameter("id") %> , successfully...</h3>

<%@include file = "studentPage.jsp" %>

</body>
</html>