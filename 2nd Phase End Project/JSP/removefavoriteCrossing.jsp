<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="com.dao.railwayCrossingDataDAO"%>
<%@page import="com.pojo.railwayCrossingData"%>
<%@page import="java.util.*"%>
<%@page import="com.dao.favouriteCrossingDAO"%>
<%@page import="com.pojo.favouriteCrossing"%>
<%@page errorPage="error.jsp" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove</title>
</head>
<body>


<%

		favouriteCrossingDAO dao = new favouriteCrossingDAO();
		favouriteCrossing data = new favouriteCrossing();
		
		
		data.setFavId(Integer.parseInt(request.getParameter("id")));
		List<favouriteCrossing> listCrossing = dao.deletefavouriteCrossing(data);
		
		response.sendRedirect("addfavoriteCrossing.jsp");	

%>

</body>
</html>