<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<style type="text/css">
h1 {
	background-color: Khaki;
	color: orange;
	font-size: 50px;
	text-transform: uppercase;
	text-align: center;
	font-weight: bold;
}

ul {
	list-style-type: none;
}

li {
	margit: 30px;
	text-align: center;
}

a:link {
	margin: 15px;
	color: green;
	text-align: center;
	font-size: 30px;
}

a:visited {
	margin: 15px;
	color: green;
	text-align: center;
}

a:hover {
	margin: 15px;
	color: lime;
	text-align: center;
}
</style>
</head>
<body>
	<h1>Employee Directory</h1>
	<ul>
		<li><a href="/EmployeeDirectory/list">Go to the list of
				employees</a>
		<li>
		<li><a href="/EmployeeDirectory/addEmployee">Add a new
				employee</a></li>
				<li><a href="/EmployeeDirectory/createReport">Create report</a></li>
	</ul>
</body>
</html>