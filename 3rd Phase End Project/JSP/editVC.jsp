<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT</title>
</head>
<body>

	<style>
			.dbl-border {
					  border: 5px double black;
					  width: 30%;
					  height: 300px;
					  }
			
			table td {
					  padding: 0.5rem;
					  border: 2px solid black;
			}

			</style>

	<div >
		
		<form action="edit">
		<table class="dbl-border">
		<tr>
			<th colspan="2"> Edit <%=request.getParameter("id") %> </th>
		</tr>
		
		<input type="hidden" name="id" value="<%= request.getParameter("id") %>">
	
		<tr>
			<td style="width: 20%"> Center Name </td>
		    <td><input type="text" name="centername"></td>
		    </tr>
		    
		 <tr >     
		     <td style="width: 20%"> Center City </td>
		     <td>
		     <select name="centercity">
		     <option value="Mumbai">Mumbai</option>
		     <option value="Pune">Pune</option>
		     <option value="Hyderabad">Hyderabad</option>
		     <option value="Bengaluru">Bengaluru</option>
		     </select>
		     </td>
		 </tr>

		  <tr>     
		      <th colspan="2"> <input type="submit" value=" Submit "></th>
		    </tr>   
		</table>
		</form>
	</div>
	
</body>
</html>