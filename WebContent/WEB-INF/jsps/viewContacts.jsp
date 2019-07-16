<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Contact</h1>

<table border="0">
<tr>
	<th>Name</th>
	<th>Phone Number</th>
	<th>Address</th>
	<th>E-mail</th>
	<th>Edit</th>
	<th>Delete</th>
</tr>	

<c:forEach items="${songlist}" var="song">

<tr>
	<th>${song.name}</th>
	<th>${song.phoneNumber}</th>
	<th>${song.address}</th>
	<th>${song.email}</th>
	<th><a href="<c:url value="/editsong/${song.id}" />">Edit</a></th>
	<th><a href="<c:url value="/deletesong/${song.id}" />">Delete</a></th>
</tr>

</c:forEach> 

</table>
	<a href="/Assignment11/register">Add Contact</a>
</body>
</html>