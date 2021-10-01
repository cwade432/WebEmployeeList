<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
<style>
body {background-color: powderblue;}
.h1{
	font-family: Arial, Helvetica, sans-serif;
}
.h2{
	font-family: "Lucida Console", "Courier New", monospace;
}
.p1{
	font-family: Arial, Helvetica, sans-serif;
}
.p2{
	font-family: "Lucida Console", "Courier New", monospace;
}
.p2{
	font-family: "Lucida Console", "Courier New", monospace;
}
</style>
</head>
<body>
<h1 class="h1">Edit an Employee</h1>
<h2 class="h2">Edit Name, Address, or Position for an Employee</h2>
<p class="p1"> Employee: </p>	
	<form action="editEmployeeServlet" method="post">
	Name: <input type="text" name="name" value="${itemToEdit.name}">
	Address: <input type="text" name="address" value="${itemToEdit.address}">
	Position: <input type="text" name="position" value="${itemToEdit.position}">
	<input type="hidden" name="id" value="${itemToEdit.id}">
	<input type="submit" value="Save Edited Item">
	</form>
</body>
</html>