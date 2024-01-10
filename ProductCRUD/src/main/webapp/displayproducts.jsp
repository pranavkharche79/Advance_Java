<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<style type="text/css">
    <%@include file="displayproducts.css" %>
</style>
</head>
<body>
<main>
  <table>
    <thead>
      <tr>
        <th>Productid</th>
        <th>Title</th>
        <th>Description</th>
        <th>Unitprice</th>
        <th>Categoryid</th>
        <th>Unitinstock</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      
      <c:forEach var="emp" items="${lst}">
      	<tr>
      	<td data-title='Provider Name'>${emp.pid}</td>
		<td data-title='Provider Name'>${emp.title}</td>
		<td data-title='Provider Name'>${emp.desc}</td>
		<td data-title='Provider Name'>${emp.unit}</td>
		<td data-title='Provider Name'>${emp.catid}</td>
		<td data-title='Provider Name'>${emp.unitstock}</td>
		<td class='select'>
		<a href="deleteprod?pid=${emp.pid}" class='button'>delete</a><br>
		<a href="editprod?pid=${emp.pid}" class='button'>edit</a>
		</td>
		</tr>
	  </c:forEach>
      
    </tbody>
  </table>
</main>
<br>
<div style="text-align: center;">
<h2><a href="addprod.jsp" type="button" class="btn btn-outline-primary" style="font-size: 25px; ">Add New Product</a></h2>
</div>
</body>
</html>