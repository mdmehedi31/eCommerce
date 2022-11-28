<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"  %>
<html>
<head>
    <title>Show Product</title>
    <style>
        table, th, td{
            border: 1px solid black;
            border-radius: 10px;
        }
        th{
            background-color: darkcyan;
        }
    </style>
</head>
<body>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th>#</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Stock</th>
        <th>Supplier</th>
        <th>Operation</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}"  varStatus="counter">
        <tr>
            <td>${counter.count}</td>
            <td>${product.productName}</td>
            <td>${product.productPrice}</td>
            <td>${product.stock}</td>
            <td>${product.supplierId}</td>
            <td>
                <a href="<c:url value="/editProduct/${product.productId}"/>" class="btn btn-success"> EDIT</a>
                <a href="<c:url value="/deleteProduct/${product.productId}"/>" class="btn btn-danger">DELETE</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
