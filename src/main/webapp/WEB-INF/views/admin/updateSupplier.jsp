<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"  %>
<html>
<head>
  <title>Title</title>
</head>
<body>



<%--@elvariable id="supplier" type="com.ecommerce.entity.Supplier"--%>
<form:form action="${pageContext.request.contextPath}/updateSupplier" method="post"
           modelAttribute="supplier">
  <table>
    <tr>
      <td colspan="2">
        <center><h3>Add Category</h3></center>
      </td>
    </tr>

    <tr>
      <td align="center">Supplier Id</td>
      <td>
        <input type="text" contenteditable="false" name="supplierId" value="${supplier.supplierId}" readonly>
      </td>
    </tr>
    <tr>
      <td align="center">Supplier Name</td>
      <td colspan="2">
        <input type="text" name="supplierName" value="${supplier.supplierName}"/>
      </td>
    </tr>

    <tr>
      <td align="center">Supplier Address</td>
      <td colspan="2">
        <input type="text" name="supplierAddress" value="${supplier.supplierAddress}"/>
      </td>
    </tr>

    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="Update">
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>
