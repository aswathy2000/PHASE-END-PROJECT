<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page errorPage="error.jsp" %>       
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Updated Student</title>
</head>
<body>


<h3 style="text-align: center; color: red;"> Updated Student '<%=request.getAttribute("Namestudent") %>' record successfully ...</h3>

<%@include file = "studentPage.jsp" %>


</body>
</html>