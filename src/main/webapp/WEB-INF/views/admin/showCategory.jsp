<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"  %>
<html>
<head>
    <title>Show Category</title>

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
            <th>Category Name</th>
            <th>Category Description</th>
            <th>Operation</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="category" items="${categories}"  varStatus="counter">
        <tr>
            <td>${counter.count}</td>
            <td>${category.categoryName}</td>
            <td>${category.categoryDesc}</td>
            <td>
                <a href="<c:url value="/editCategory/${category.categoryId}"/>" class="btn btn-success"> EDIT</a>
                <a href="<c:url value="/deleteCategory/${category.categoryId}"/>" class="btn btn-danger">DELETE</a>
            </td>
        </tr>
    </c:forEach>
        </tbody>
</table>

</body>
</html>
