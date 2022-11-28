<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"  %>
<html>
<head>
  <title>Title</title>

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
    <th>Supplier Name</th>
    <th>Supplier Address</th>
    <th>Operation</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="supplier" items="${suppliers}"  varStatus="counter">
    <tr>
      <td>${counter.count}</td>
      <td>${supplier.supplierName}</td>
      <td>${supplier.supplierAddress}</td>
      <td>
        <a href="<c:url value="/editSupplier/${supplier.supplierId}"/>" class="btn btn-success"> EDIT</a>
        <a href="<c:url value="/deleteSupplier/${supplier.supplierId}"/>" class="btn btn-danger">DELETE</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>
