<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTER FORM</title>
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
		<h1>Admin Registration</h1>
		<form action="registration">
		<table class="dbl-border">
		<tr>
			<th colspan="2"> Registration </th>
		</tr>
		<tr>
			<td style="width: 20%"> Name:</td>
		    <td><input type="text" name="username"></td>
		    </tr>
		    
		 <tr >     
		     <td style="width: 20%"> Email:</td>
		     <td><input type="email" name="email"></td>
		 </tr>
		 
		 <tr>    
		 	 <td style="width: 20%"> Password: </td>
		  	 <td><input type="password" name="password"></td>
		  </tr>
		  <tr>     
		      <th colspan="2"> <input type="submit" value="Register"></th>
		    </tr>   
		</table>
		</form>
	</div>

</body>
</html>