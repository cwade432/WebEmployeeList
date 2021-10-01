<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All Employees</title>
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
<h1 class="h1">Full Employee List</h1>
<h2 class="h2">Add, Edit, or Delete an Employee from the List</h2>
<p class="p1"> Employee list results: </p>	
	<form method="post" action="employeeNavigationSerlvet">
		<table>
		<c:forEach items="${requestScope.allItems}" var="currentitem"> <!-- Cycles through list and prints out each item -->
		<tr>
			<td><input type="radio" name="id" value="${currentitem.id}"></td>
			<td>${currentitem.name}</td>
			<td>${currentitem.address}</td>
			<td>${currentitem.position}</td>
		</tr>		
		</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToItem">
		<input type="submit" value="delete" name="doThisToItem">
		<input type="submit" value="add" name="doThisToItem">
	</form>
</body>
</html>