<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="com.project.dao.ClassDAO"%>
<%@page import="com.project.pojo.Classes"%>
<%@page import="java.util.*"%>

 <%@page errorPage="error.jsp" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Class</title>
</head>
<body>

<%

ClassDAO dao1 = new ClassDAO();
Classes class1 = new Classes();


class1.setClassId((Integer.parseInt(request.getParameter("id"))));
List<Classes> listSubject = dao1.deleteClasses(class1);


%>


<h3 style="text-align: center; color: red;"> Deleted Class record for Class-Id :  <%=request.getParameter("id") %> , successfully...</h3>

<%@include file = "dashboard.jsp" %>

</body>
</html>