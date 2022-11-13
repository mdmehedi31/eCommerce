<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%--@elvariable id="category" type="com.ecommerce.entity.Category"--%>
<form:form action="${pageContext.request.contextPath}/updateCategory" method="post"
           modelAttribute="category">
    <table>
    <tr>
        <td colspan="2">
            <center><h3>Add Category</h3></center>
        </td>
    </tr>

    <tr>
        <td align="center">Category Id</td>
        <td>
            <input type="text" contenteditable="false" name="categoryId" value="${category.categoryId}" readonly>
        </td>
    </tr>
    <tr>
        <td align="center">Category Name</td>
        <td colspan="2">
            <input type="text" name="categoryName" value="${category.categoryName}"/>
        </td>
    </tr>

    <tr>
        <td align="center">Category Desc</td>
        <td colspan="2">
            <input type="text" name="categoryDesc" value="${category.categoryDesc}"/>
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
