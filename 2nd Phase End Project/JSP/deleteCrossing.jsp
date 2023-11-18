<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.pojo.railwayCrossingData"%>
<%@page import="com.dao.railwayCrossingDataDAO"%>
<%@page import="java.util.*"%>
<%@page errorPage="error.jsp" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Crossing</title>
</head>
<body>


<%

		railwayCrossingDataDAO dao = new railwayCrossingDataDAO();
		railwayCrossingData data = new railwayCrossingData();
		
		
		data.setCrossingId(Integer.parseInt(request.getParameter("id")));
		List<railwayCrossingData> listCrossing = dao.deleteRailwayCrossingData(data);
		
		response.sendRedirect("adminHomePage.jsp");	

%>

</body>
</html>