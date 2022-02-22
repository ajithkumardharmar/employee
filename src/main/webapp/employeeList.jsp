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
			Emp code : <input type="text" name="empCode">
		</div>
		
	
		<div>
			City : <input type="text" name="empCity">
		</div>
		<div>
			State : <input type="text" name="empState">
		</div>
		<div>
			Joining Date From : <input type="date" name="fromDate">
		</div>
		<div>
			Joining Date To : <input type="date" name="toDate">
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
					<td>${employeeDetails.empCode }</td>
					<td>${employeeDetails.empName }</td>
					<td>${employeeDetails.empEmail }</td>
					<td>${employeeDetails.empCity}</td>
					<td>${employeeDetails.empState}</td>
					
				</tr>
	<c:set var="serialNumber" value="${serialNumber+1 }" scope="page"></c:set>
			</c:forEach>



		</table>
	
</body>
</html>