<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--@elvariable id="product" type="com.ecommerce.entity.Product"--%>
<form:form action="${pageContext.request.contextPath}/updateProduct" method="post"
           modelAttribute="product">
<table>
  <tr>
    <td colspan="2">
      <center><h3>Update Product</h3></center>
    </td>
  </tr>

  <tr>
    <td align="center"> ID</td>
    <td>
      <input type="text" contenteditable="false" name="productId" value="${product.productId}" readonly>
    </td>
  </tr>
  <tr>
    <td align="center">Name</td>
    <td colspan="2">
      <input type="text" name="productName" value="${product.productName}"/>
    </td>
  </tr>

  <tr>
    <td align="center">Price</td>
    <td colspan="2">
      <input type="text" name="Price" value="${product.productPrice}"/>
    </td>
  </tr>

  <tr>
    <td align="center">Stock</td>
    <td colspan="2">
      <input type="text" name="stock" value="${product.stock}"/>
    </td>
  </tr>



  <tr>
    <td align="center">Supplier Id</td>
    <td colspan="2">
      <input type="text" name="supplierId" value="${product.supplierId}"/>
    </td>
  </tr>

  <tr>
    <td align="center">Description</td>
    <td colspan="2">
      <input type="text" name="description" value="${product.productDesc}"/>
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
