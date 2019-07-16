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
<h1>Search Song</h1>

<form  action="/Assignment11/contactSearch" method="post" >
Search By  :<select name="searchBy">
  <option value="name"> name</option>
  <option value="phoneNumber"> phoneNumber </option>
  <option value="address"> address</option>
  <option value="email"> email </option>
  </select>
  <input type="text" name="inputText"/><br/>
 	<br/><br/>
	<center>
		<input type="SUBMIT"/>
	</center>
	<br/><br/>
</form>


     
<h1>Songs</h1>

<table border="0">
<tr>
<th>Name</th><th>phone number</th><th>address</th><th>email</th>
</tr>	

<c:forEach items="${contactlist}" var="song">

<tr>
<th>${song.name}</th><th>${song.phoneNumber}</th><th>${song.address}</th><th>${song.email}</th>
</tr>
</c:forEach> 

</table>


</body>
</html>