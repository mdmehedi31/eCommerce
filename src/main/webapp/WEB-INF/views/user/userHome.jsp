<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"  %>
<html>
<head>
    <title>Title</title>
    <style>
    .col-sm-4 {
    width: 18rem;
    }
    </style>
</head>
<body>

        <h3></h3>

     <div class="row">
          <c:forEach items="${productList}" var="product">
            <div class="col-sm-4 col-md-3">
              <img src="/image/${product.getAttachment().getAttachmentPath()}" alt="${product.getAttachment().getAttachmentPath()}" />

              <p align="center">${product.productName}</p>
              <p align="center">Price: TK ${product.productPrice}</p>
              <p align="center">Stock: ${product.stock}</p>
              <a href="<c:url value="/totalProductDisplay/${product.productId}"/>" class="btn btn-primary">Add To Cart</a>
             <%-- <a href="#" class="btn btn-primary">Buy Now</a>--%>
            </div>
          </c:forEach>
     </div>
</body>
</html>
