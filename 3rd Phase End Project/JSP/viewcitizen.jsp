<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VIEW CITIZEN</title>
</head>
<body>

<style>
	body {
	margin : 20px;
	}
			.table-style {
					  border: "1";
					  width: 30%;
					  height: 200px;
					  text-align: center;
					  }
			.main {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            padding: 5px;
            margin: 0 5px;
       }
 
       

   </style>

</head>
<body>

<%@include file="dashboard.jsp" %>

<div>

	<h1> Citizen Information </h1>
	
	
	<table class="table-style">
	<% Citizen vc = (Citizen) request.getAttribute("center");%>
       <tr>
       	<th colspan="2" height="50px" >
       	<%=vc.getPersonName() %>
        
       </th>
       </tr>
       
       <tr height="50px">
           <td width="50%">ID</td>
           <td width="50%"><%=vc.getId()%></td>
       </tr>

	<tr height="50px">
		<td width="50%">City</td>
		<td width="50%"><%=vc.getVaccinationCenter().getVaccinationCenterCity() %></td>
	</tr>
	
	<tr height="50px">
		<td width="50%">Number of Vaccines</td>
		<td width="50%"><%=vc.getNumberOfDoses() %></td>
	</tr>
	
	<tr height="50px">
		<td width="50%">Vaccination Status</td>
		<td width="50%"><%=vc.getVaccinationStatus()%></td>
	</tr>
	
	<tr height="50px">
		<td width="50%">Allocated Vaccination Center</td>
		<td width="50%"><a href="view?id=<%= vc.getVaccinationCenter().getVaccinationCenterId() %>">
		<%=vc.getVaccinationCenter().getVaccinationCenterName() %></a></td>
	</tr>


</table>

</div>

</body>
</html>