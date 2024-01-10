<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <link rel="stylesheet" href="addprod.css" -->
<style type="text/css">
    <%@include file="addprod.css" %>
</style>
    
    <title>Document</title>
</head>
<body>
    <div class="add-product">
        <h2>Add a Product</h2>
        <form action="insertprod" method="post">
            <label for="title">Product Title:</label>
            <input type="text" id="title" name="title" required>
            
            <label for="desc">Product Description:</label>
            <textarea id="desc" name="desc" required></textarea>
            
            <label for="price">Product UnitPrice:</label>
            <input type="number" id="price" name="price" step="0.01" required>
            
            <label for="cid">Product CategoryID:</label>
            <input type="number" id="cid" name="cid" required>
            
            <label for="stock">Product UnitStock:</label>
            <input type="number" id="stock" name="stock" required>
            
            <button type="submit" id="btn" name="btn">Add Product</button>
        </form>
    </div>
</body>
</html>