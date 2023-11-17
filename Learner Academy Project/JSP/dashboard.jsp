<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.project.dao.ClassDAO"%>
<%@page import="com.project.pojo.Classes"%>
<%@page import="java.util.*"%> 

 <%@page errorPage="error.jsp" %>     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DASHBOARD</title>
</head>
<body>

		<div style="text-align: center">		

		<h1 style="color: midnight-blue"><b>		Welcome !		</b></h1> 		
		
		</div>
		
		
		<div style="text-align: center; border: 2px solid black;  margin: 30px 30px; padding: 20px; height: 30px">
				
		<a href="dashboard.jsp" style="padding: 10px;"> Class </a>
		<a href="studentPage.jsp" style="padding: 10px;"> Student </a>
		<a href="subjectPage.jsp" style="padding: 10px;"> Subject </a>
		<a href="teacherPage.jsp" style="padding: 10px;"> Teacher </a>
		
		<a href="logout.jsp" style="padding: 10px;"> Logout </a>
		</div>
		
		
		<div style="text-align: center; margin: 30px">
		
		<form action="addClass.jsp">		
		<br><br>
		<input type = "submit" value = "		Add Class		">		
		</form>		
		<br><br>
		</div>				
		<div align="center">
		
		<table border="1" cellpadding="5" style=" width:80%; border: 3px solid black ;border-collapse: collapse;">
		
		 <tr>
           <th> Class-Id </th>
           <th> Class-Name </th>
           <th> Assign subject and teacher </th>
           <th> Edit Class </th>
           <th> Delete Class </th>
           <th> View Subjects, Teachers and Students </th>
          
       	</tr>
		
		<%
           ClassDAO dao = new ClassDAO();
           List<Classes> classList = dao.displayClasses();
           Set<String> uniqueClassNames = new HashSet<String>();
           for (Classes classes : classList) {
               String className = classes.getClassName();
               
               if (uniqueClassNames.add(className)) {        
               
         %>
         
	       <tr>
	           <td><%= classes.getClassId() %></td>
	           <td><%= className %></td>
	           <td><a href="AssignSubjectTeacherForclass.jsp?name=<%= classes.getClassName() %>">Assign subject and teacher</a></td>
	           <td><a href="updateClass.jsp?id=<%= classes.getClassId() %>"> Edit </a></td>
	           <td><a href="deleteClass.jsp?id=<%= classes.getClassId() %>"> Delete </a></td>
	           <td><a href="viewReport.jsp?name=<%= classes.getClassName() %>"> View Report </a></td>
	          
	       </tr>
       	
       	<% } }%>     
       
   		</table>
   		
   		</div>
	

</body>
</html>