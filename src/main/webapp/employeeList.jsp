<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
    <%@ page isELIgnored = "false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 20px;
	
}
table{
margin-left:30px;
width: 95%;
}
a{
color:black;
text-decoration: none;
}
a hover{
background-color:  blue;
}
body{
background-color: lightblue;
}div {
	padding: 6px;
}
.empMain{
margin-left: 400px;
}
</style>
</head>
<body>
<div class="empMain">
<h1>Search Employee Details</h1>
	<form action="searchEmp" method="post">
		<div>
			Emp code : <input type="text" name="sempCode">
		</div>
		
	
		<div>
			City : <input type="text" name="sempCity">
		</div>
		<div>
			State : <input type="text" name="sempState">
		</div>
		<div>
			Joining Date From : <input type="date" name="sfromDate">
		</div>
		<div>
			Joining Date To : <input type="date" name="stoDate">
		</div>
		<div>
		<button type="submit">Search</button>	<button type="reset">Reset</button>
		</div>
	</form>
	</div>
	<table aria-describedby="Show All home places" id="orders">
			<tr style="background-color: cornflowerblue">
				<th>Serial No</th>
				<th>EmpCode</th>
				<th>EmpName</th>
				<th>EmpEmail</th>
				<th>EmpCity</th>
				<th>EmpState</th>
			</tr>
		
		<c:set var="serialNumber" value="1" scope="page"></c:set>
			<c:forEach items="${employeeDetails}" var="employeeDetails">

				<tr>
					<td>${serialNumber}</td>
					<td><a href="searchOne?employeeCode=${employeeDetails.empCode }"> ${employeeDetails.empCode }</a></td>
					<td> <a href="searchOne?employeeCode=${employeeDetails.empCode }"> ${employeeDetails.empName }</a></td>
					<td> <a href="searchOne?employeeCode=${employeeDetails.empCode }"> ${employeeDetails.empEmail }</a></td>
					<td> <a href="searchOne?employeeCode=${employeeDetails.empCode }"> ${employeeDetails.empCity}</a></td>
					<td> <a href="searchOne?employeeCode=${employeeDetails.empCode }"> ${employeeDetails.empState}</a></td>
					
				</tr>
	<c:set var="serialNumber" value="${serialNumber+1 }" scope="page"></c:set>
			</c:forEach>



		</table>
		</body>
	</html>