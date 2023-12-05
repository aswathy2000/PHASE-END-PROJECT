<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@page import="com.example.demo.pojo.*" %>
 <%@page import="java.util.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VACCINATION CENTER HOME PAGE</title>
</head>
<body>

<%@include file="dashboard.jsp" %>


	<style>
	body {
	margin : 20px;
	}
			.table-style {
					  border: "1";
					  width: 60%;
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

<h1>Centers</h1>

 <%List<Vaccinationcenter> list=(List<Vaccinationcenter>)request.getAttribute("list"); %>
          
      
       <table class="table-style">
       <tr>
       	<th colspan="4" height="50px" style="text-align: right; padding-right:15px">
       	<form action="addVaccinationCenter.jsp" method="post">
            <input type="submit" value=" Add New Center ">
        </form>
       </th>
       </tr>
       
       <tr height="50px">
           <td width="10%">ID</td>
           <td width="30%">Vaccination Center Name</td>
           <td width="30%">City</td>
           <td width="20%">Action</td>
       </tr>
<%for(Vaccinationcenter ss:list){ %>
<tr>
<td><%=ss.getVaccinationCenterId()%></td>
<td><%=ss.getVaccinationCenterName() %></td>
<td><%=ss.getVaccinationCenterCity() %></td>
               <td>
                   <div class="main">
              
                   <form action="view?id=<%=ss.getVaccinationCenterId()%>" method="post">
                       <input type="submit" value="View">
                   </form>
					
                  <form action="editVC.jsp?id=<%=ss.getVaccinationCenterId()%>" method="post">
                       <input type="submit" value="Edit">
                   </form>
                  <form action="deleteVC?id=<%=ss.getVaccinationCenterId()%>" method="post">
                  	  <input type="submit" value="Delete">
                  </form>
                   </div>
               </td>
               
               
</tr>


<%} %>
<tr>
<td colspan="4"> Total <%= list.size() %> Vaccination Center found. </td>
</tr>
</table>



</body>
</html>