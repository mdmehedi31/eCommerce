<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--@elvariable id="supplierDto" type="com.ecommerce.dto.SupplierDto"--%>
<form:form action="${pageContext.request.contextPath}views/supplier" method="post"
        modelAttribute="supplierDto" >
<table class="table">

  <tr>
    <td colspan="2">
      <center><h3>Add Supplier</h3></center>
    </td>
  </tr>

  <tr>
    <td align="center">Supplier Name</td>
    <td><form:input type="text" cssclass="form-control" id="categoryName" placeholder="Name" path="supplierName" ></form:input></td>
  </tr>

  <tr>
    <td align="center">Supplier Address</td>
    <td><form:input  type="text" cssclass="form-control" id="categoryDes" placeholder="Address"  path="supplierAddress"></form:input></td>
  </tr>

  <tr>
    <td colspan="2" align="center">
      <input type="submit" value="SUBMIT">
    </td>
  </tr>
</table>
</form:form>
</body>
</html>
