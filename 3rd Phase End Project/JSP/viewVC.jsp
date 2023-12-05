<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VIEW</title>

<style>
	body {
	margin : 20px;
	}
			.table-style {
					  border: "1";
					  width: 25%;
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

	<h1> Center Information </h1>
	
	
	<table class="table-style">
	<% Vaccinationcenter vc = (Vaccinationcenter) request.getAttribute("center");%>
       <tr>
       	<th colspan="2" height="50px" >
       	<%=vc.getVaccinationCenterName() %>
        
       </th>
       </tr>
       
       <tr height="50px">
           <td width="50%">ID</td>
           <td width="50%"><%=vc.getVaccinationCenterId()%></td>
       </tr>

	<tr height="50px">
		<td width="50%">City</td>
		<td width="50%"><%=vc.getVaccinationCenterCity() %></td>
	</tr>
	
	</table>
	
	<hr>
	
	<%
          List<Citizen> citizens = (List<Citizen>) request.getAttribute("citizens");
          if (citizens != null && !citizens.isEmpty()) {
       %>
           <table class="table-style">
               <tr height="50px">
                   <td width="30%">ID</td>
                   <td width="40%">Name</td>
                   <td width="30%">Action</td>
                   </tr>
               <% for (Citizen citizen : citizens) { %>
                   <tr height="50px">
                   <td><%= citizen.getId() %></td>
                    <td><%= citizen.getPersonName() %></td>
                    <td>
   <a href="viewcitizen?id=<%= citizen.getVaccinationCenter().getVaccinationCenterId() %>">
       View
   </a>
</td>
                        </tr>
               <% } %>
           </table>
       <% } else { %>
           <p> No citizens for this center.</p>
       <% } %>

  
	

</div>
</body>
</html>