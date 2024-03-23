<%--
  Created by IntelliJ IDEA.
  User: carlosleon
  Date: 3/22/24
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inventory</title>
</head>
<body>
<h1>Inventory</h1>
<form action="searchProduct" method="get">
    <input type="text" name="searchTerm" placeholder="Enter Product ID">
    <input type="submit" name="submit" value="Search">
</form>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Quantity</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.productId}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.quantity}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
