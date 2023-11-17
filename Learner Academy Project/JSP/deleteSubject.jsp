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
<title>Delete Subject</title>
</head>
<body>

<%

SubjectDAO dao1 = new SubjectDAO();
Subject subject1 = new Subject();


subject1.setSubjectId((Integer.parseInt(request.getParameter("id"))));
List<Subject> listSubject = dao1.deleteSubject(subject1);


%>


<h3 style="text-align: center; color: red;"> Deleted Subject record for Subject-Id :  <%=request.getParameter("id") %> , successfully...</h3>

<%@include file = "subjectPage.jsp" %>

</body>
</html>