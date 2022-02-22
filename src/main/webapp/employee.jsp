<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter employee details</title>
<style type="text/css">
div {
	padding: 10px;
}
.empMain{
margin-left: 400px;
}
body{
background-color: lightblue;
}
</style>
</head>

<body>
<div class="empMain">
	<h1>Add Employee Details</h1>
	<form action="addEmp" method="post">
		<div>
			Emp code* : <input type="text" name="empCode" required>
		</div>
		<div>
			Emp Name* : <input type="text" name="empName" required>
		</div>
		<div>
			Email* : <input type="email" name="empEmail" required>
		</div>
		<div>
			Address1* : <input type="text" name="empAddress1" required>
		</div>
		<div>
			Address2 : <input type="text" name="empAddress2" >
		</div>
		<div>
			city* : <input type="text" name="empCity" required>
		</div>
		<div>
			state* : <input type="text" name="empState" required>
		</div>
		<div>
			Date of Birth* : <input type="date" name="dateOfBirth" required>
		</div>
		<div>
			Joining Date* : <input type="date" name="joiningDate" required>
		</div>
		<div>
		<button type="submit">Submit</button>	<button type="reset">Reset</button>
		</div>
	</form>
	<a href="viewEmployee">Search Employee</a>
	</div>
</body>
</html>