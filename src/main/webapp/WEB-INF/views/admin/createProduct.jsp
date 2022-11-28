<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>




<%--@elvariable id="product" type="com.ecommerce.entity.Product"--%>
<form:form action="${pageContext.request.contextPath}views/createProduct" method="post"
           modelAttribute="product" enctype="multipart/form-data">
    <table class="table">

        <tr>
            <td colspan="2">
                <center><h3>Add Product</h3></center>
            </td>
        </tr>

        <tr>
            <td align="left"> Name</td>
            <td><form:input type="text" cssclass="form-control" id="productName" placeholder="Name" path="productName" ></form:input></td>
        </tr>

        <tr>
            <td align="left">Product Price</td>
            <td><form:input  type="text" cssclass="form-control" id="productPrice" placeholder="Price"  path="productPrice"></form:input></td>
        </tr>

        <tr>
            <td align="left">Stock In</td>
            <td><form:input  type="text" cssclass="form-control" id="stock" placeholder="stock in"  path="stock"></form:input></td>
        </tr>

        <tr>
            <td align="left">Category</td>
            <td>
                <form:select cssClass="dropdown" path="category">
                    <form:option selected="true" value="Select Category" disabled="true"/>
                    <form:options items="${categoryList}"/>
                </form:select>
            </td>
        </tr>

        <tr>
            <td align="left">Supplier</td>
            <td><form:input  type="text" cssclass="form-control" id="supplier" placeholder="supplier"  path="supplierId"></form:input></td>
        </tr>

        <tr>
            <td align="left">Product Picture</td>
            <td>
                <input type="file"  name="image"  accept="image/*"/>
            </td>
        </tr>

        <tr>
            <td align="left">Product Description</td>
            <td><form:textarea cssclass="form-control" id="Description"
                             placeholder="Description"  path="productDesc"></form:textarea></td>
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
