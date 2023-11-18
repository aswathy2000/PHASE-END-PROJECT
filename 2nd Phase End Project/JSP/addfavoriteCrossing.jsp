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
<title>Add Favorite Crossing</title>
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
		<br><h1><b> Favorite Railway Crossing </b></h1> 
			
		</div>
		
		<div style ="margin: 20px; padding: 10px">
		<form>
		<button type= "submit" formaction="userHomePage.jsp"><b> All </b></button>
		<button type= "submit" formaction="searchHomePage.jsp"><b> Search Crossing </b></button>
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
			
			<th colspan="2" style="width: 12%">Remove from Favorite </th>
			
		</tr>
		
		
			<%
			 
	           try {
	               favouriteCrossingDAO dao = new favouriteCrossingDAO();
	               List<favouriteCrossing> favCrossingData = dao.displayfavouriteCrossing();
	              
	               List<Integer> id = new ArrayList<Integer>();
	              
	               railwayCrossingDataDAO dao1 = new railwayCrossingDataDAO();
	               List<railwayCrossingData> crossingList = dao1.displayRailwayCrossingData();
	              
	               int i = 0;
	              
	               for (favouriteCrossing obj : favCrossingData) {
	                   i = obj.getRailwayCrossing().getCrossingId();
	                   id.add(i);
	               }
	              
	               for (railwayCrossingData data : crossingList) {
	                   if (id.contains(data.getCrossingId())) {
	       %>

			<tr class = "border-bottom">
			
			<td><%= data.getCrossingId()%></td>
			<td><%= data.getCrossingName() %></td>
			<td><%= data.getAddress() %></td>
			<td><%= data.getLandmark() %></td>
			<td><%= data.getTrainSchedule() %></td>
			<td><%= data.getPersonInCharge() %></td>
			<td><%= data.getStatusCrossing() %></td>
			
	
			
			
			<% 
			favouriteCrossingDAO daoFav= new favouriteCrossingDAO();
			List<favouriteCrossing> listCrossing = daoFav.displayfavouriteCrossing();
			for(favouriteCrossing obj : listCrossing) { 
			%>
			
			<form action="removefavoriteCrossing.jsp" method="post">
			<td><button type= "submit" id="fav" name = "id" value= "<%=obj.getFavId()%>"> Remove from Favorite </button>
			</td>
			</form>
			
			
			<% } %>
			
				<%  }
               }
           } 
			catch (Exception e) 
			{ 
               e.printStackTrace(); 
           }
           %>
			
			
			</tr>
			

			
			
			
			
		</table>
		
		</div>

</body>
</html>