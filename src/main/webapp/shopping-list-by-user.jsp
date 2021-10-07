<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View list by user</title>
<style>
body {background-color: powderblue;}
.h1{
	font-family: Arial, Helvetica, sans-serif;
}
.h2{
	font-family: "Lucida Console", "Courier New", monospace;
}
</style>
</head>
<body>
<h1>Client List</h1>
<h2>Add or delete a new client list</h2> 
<form method="post" action = "listnavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
	<td><input type="radio" name="id" value="${currentlist.id}"></td>
	<td><h2>${currentlist.listName}</h2></td></tr>
	<tr><td colspan="3">Trip Date: ${currentlist.tripDate}</td></tr>
	<tr><td colspan="3">Client: ${currentlist.client.clientName}</td></tr>
	<c:forEach var = "listVal" items="${currentlist.listOfItems}">
	<tr><td></td><td colspan="3"> ${listVal.name}, ${listVal.address}, ${listVal.position}</td></tr>	
</c:forEach>
</c:forEach>
</table>
<!-- <input type="submit" value="edit" name="doThisToList"> -->
<input type="submit" value="add" name="doThisToList">
<input type="submit" value="delete" name="doThisToList">
</form>
<a href="addItemsForListServlet">Create a new list</a>
<a href="index.html">Insert New Item</a>
</body>
</body>
</html>