<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<style type="text/css">
    <%@include file="addprod.css" %>
</style>
</head>
<body>
	<div class="add-product">
        <h2>Add a Product</h2>
        <form action="update" method="post">
        	
        	<label for="price">Product ID:</label>
            <input type="number" id="pid" name="pid" value="${p.pid}" step="0.01" readonly="readonly">
        
            <label for="title">Product Title:</label>
            <input type="text" id="title" name="title" value="${p.title}" required>
            
            <label for="desc">Product Description:</label>
            <input id="desc" name="desc" value="${p.desc}" required />
            
            <label for="price">Product UnitPrice:</label>
            <input type="number" id="price" name="price" value="${p.unit}" step="0.01" required>
            
            <label for="cid">Product CategoryID:</label>
            <input type="number" id="cid" name="cid" value="${p.catid}" required>
            
            <label for="stock">Product UnitStock:</label>
            <input type="number" id="stock" name="stock" value="${p.unitstock}" required>
            
            <button type="submit" id="btn" name="btn">Update Product</button>
        </form>
    </div>
</body>
</html>