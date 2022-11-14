<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"  %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>

<%--@elvariable id="categoryDto" type="com.ecommerce.dto.CategoryDto"--%>
<form:form action="${pageContext.request.contextPath}views/category" method="post"
            modelAttribute="categoryDto">
    <table class="table">

      <tr>
         <td colspan="2">
           <center><h3>Add Category</h3></center>
         </td>
      </tr>

     <tr>
       <td align="center">Category Name</td>
         <td><form:input type="text" cssclass="form-control" id="categoryName" placeholder="Name" path="categoryName" ></form:input></td>
     </tr>

     <tr>
       <td align="center">Category Desc</td>
         <td><form:input  type="text" cssclass="form-control" id="categoryDes" placeholder="CategoryDes"  path="categoryDesc"></form:input></td>
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
