<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page errorPage="error.jsp" %>       
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Updated Class</title>
</head>
<body>


<h3 style="text-align: center; color: red;"> Updated Class '<%=request.getAttribute("Classname") %>' record successfully ...</h3>

<%@include file = "dashboard.jsp" %>

</body>
</html>