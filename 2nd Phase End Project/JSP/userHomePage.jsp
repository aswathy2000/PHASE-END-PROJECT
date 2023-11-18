<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.dao.railwayCrossingDataDAO"%>
<%@page import="com.pojo.railwayCrossingData"%>
<%@page import="java.util.*"%>
<%@page errorPage="error.jsp" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home Page</title>
</head>
<body>


		<style>
		.button{
		background-color: grey; 
		border:none; 
		border-radius:20px; 
		color:white;  
		padding: 10px  60px";
		
		}
		
				
		table th, table td {
		  padding: 10px;
		  text-align: left;
		}
		
		tr.border-bottom td {
			border-bottom: 2px solid black;
		}
		
		</style>


		<div style="margin: 20px; padding: 10px">
		<br><h1><b> User Home Page </b></h1> 
		
		<h3><b> Railway Crossings </b></h3>		
		</div>
		
		<div style ="margin: 20px; padding: 10px">
		<form>
		<button type= "submit" formaction="userHomePage.jsp"><b> All </b></button>
		<button type= "submit" formaction="addfavoriteCrossing.jsp"><b> Favorite Crossing</b></button>
		<button type= "submit" formaction="searchUserHomePage.jsp"><b> Search Railway Crossing</b></button>
		<button type= "submit" formaction="logout.jsp"><b>Logout</b></button>
		</form>
		</div>	
		
		<div style="width=100%">		
		
		<table  cellpadding="5" style="width:100%; ">		
		<tr class = "border-bottom">
		
			<th style="width: 5%">Sr. No</th>
			<th style="width: 15%">Name</th>
			<th style="width: 20%">Address</th>
			<th style="width: 20%">Landmark</th>
			<th style="width: 10%">Train Schedule</th>
			<th style="width: 10%">Person In-charge</th>
			<th style="width: 5%">Status</th>
			
			<th colspan="2" style="width: 12%">Add To Favorite </th>
			
		</tr>
		
		
			<%
			railwayCrossingDataDAO dao = new railwayCrossingDataDAO();
			List<railwayCrossingData> crossingsList = dao.displayRailwayCrossingData();
			
			for(railwayCrossingData data : crossingsList){
			%>
			<tr class = "border-bottom">
			
			<td><%= data.getCrossingId()%></td>
			<td><%= data.getCrossingName() %></td>
			<td><%= data.getAddress() %></td>
			<td><%= data.getLandmark() %></td>
			<td><%= data.getTrainSchedule() %></td>
			<td><%= data.getPersonInCharge() %></td>
			<td><%= data.getStatusCrossing() %></td>
			
			<td><a href ="addfavoriteCrossing?id=<%=data.getCrossingId()%>">Add To Favorite </a></td>
			
			</tr>
			
			<%} %>
			
			
		</table>
		
		</div>

</body>
</html>