<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Citizen Center</title>
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
		
		<form action="insertcitizen">
		<table class="dbl-border">
		<tr>
			<th colspan="2"> Add new Citizen </th>
		</tr>
		<tr>
			<td style="width: 20%"> Citizen Name </td>
		    <td><input type="text" name="name"></td>
		    </tr>
		    
		 <tr >     
		     <td style="width: 20%"> Citizen City </td>
		     <td>
		     <select name="centercity">
		     <option value="Mumbai">Mumbai</option>
		     <option value="Pune">Pune</option>
		     <option value="Hyderabad">Hyderabad</option>
		     <option value="Bengaluru">Bengaluru</option>
		     </select>
		     </td>
		 </tr>
		 
		 <tr >     
		     <td style="width: 20%"> No. Of Doses </td>
		     <td>
		     <select name="noOfDoses">
		     <option value="0">None</option>
		     <option value="1">1</option>
		     <option value="2">2</option>
		     </select>
		     </td>
		 </tr>
		 
		  <tr >     
		     <td style="width: 20%"> Vaccination Center </td>
		     <td>
		     <select name="vaccinationcenter">
		     <option value="City Hosiptal">City Hosiptal</option>
		     <option value="Galaxy Clinic">Galaxy Clinic</option>
		     <option value="Sunshine Hosiptal">Sunshine Hosiptal</option>
		     <option value="Central Medical Care">Central Medical Care</option>
		     <option value="Central">Central</option>
		     <option value="Sanjeevani Clinic">Sanjeevani Clinic</option>
		     
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