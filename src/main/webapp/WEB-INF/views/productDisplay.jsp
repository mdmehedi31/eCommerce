<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"  %>
<html>
<head>
    <title>Display Product</title>
</head>
<body>

    <div class="row">

      <c:forEach items="${productList}" var="product">

        <div>
          <a href="<c:url value="/totalProductDisplay/${product.productId}" />" class="thumbnail">
           <c:forEach var="image" items="${product.getProductAttachmentList()}">
             <img src="/images/${image.getAttchmentPath()}" alt="Generic placeholder thumbnail" height="100px" width="100px" style="object-fit: cover" />
           </c:forEach>
          </a>
          <p align="center">${product.productName}</p>
          <p align="center">${product.productPrice}</p>
          <p align="center">${product.stock}</p>
        </div>


      </c:forEach>

    </div>

</body>
</html>
