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

        <div class="col-sm-4 col-md-3">
          <a href="<c:url value="/totalProductDisplay/${product.productId}" />" class="thumbnail">
              <img src="/image/${product.getAttachment().getAttachmentPath()}" alt="${product.getAttachment().getAttachmentPath()}" />
          </a>
            <tr>
                <td>
                    <label>Name: </label>
                    <p align="center">${product.productName}</p>
                </td>
                <td>
                    <label>Price: </label>
                    <p align="center">${product.productPrice}</p>
                </td>
                <td>
                    <label>Stock</label>
                    <p align="center">${product.stock}</p>
                </td>
            </tr>
            <tr>
                <td>
                    <button  class="btn btn-success">BUY</button>
                </td>
            </tr>
        </div>
      </c:forEach>

    </div>

</body>
</html>
