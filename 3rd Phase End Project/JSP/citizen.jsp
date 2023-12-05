<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CITIZEN HOME PAGE</title>
</head>
<body>

<%@include file="dashboard.jsp" %>


	<style>
	body {
	margin : 20px;
	}
			.table-style {
					  border: "1";
					  width: 70%;
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

<h1>Citizens</h1>

 <%List<Citizen> list=(List<Citizen>)request.getAttribute("list"); %>
          
      
       <table class="table-style">
       <tr>
       	<th colspan="7" height="50px" style="text-align: right; padding-right:15px">
       	<form action="addCitizen.jsp" method="post">
            <input type="submit" value=" Add New Citizen ">
        </form>
       </th>
       </tr>
       
       <tr height="50px">
           <td width="5%"> ID </td>
           <td width="15%"> Name </td>
           <td width="15%"> City </td>
           <td width="10%"> No. Of Doses </td>
           <td width="15%"> Vaccination Status </td>
           <td width="20%"> Vaccination Center </td>
           <td width="25%"> Action </td>
       </tr>
<%for(Citizen c : list){ %>
<tr>
<td><%=c.getId()%></td>
<td><%=c.getPersonName() %></td>
<td><%=c.getVaccinationCenter().getVaccinationCenterCity() %></td>
<td><%=c.getNumberOfDoses() %></td>
<td><%=c.getVaccinationStatus() %></td>
<td><%=c.getVaccinationCenter().getVaccinationCenterName() %></td>

               <td>
                   <div class="main">
              
                   <form action="viewcitizen?id=<%=c.getId()%>" method="post">
                       <input type="submit" value="View">
                   </form>
                  <form action="editCitizen.jsp?id=<%=c.getId()%>" method="post">
                       <input type="submit" value="Edit">
                   </form>
                  <form action="deletecitizen?id=<%=c.getId()%>" method="post">
                  <input type="submit" value="Delete">
                  </form>
                   </div>
               </td>
               
               
</tr>


<%} %>
<tr>
<td colspan="7"> Total <%= list.size() %> Vaccination Center found. </td>
</tr>
</table>



</body>
</html>