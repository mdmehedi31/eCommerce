<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Total Product Display</title>
    <style>

        .cart-btn{
            background-color: #199319;
            color: #111111;
            padding: 10px 15px;
            text-decoration: none;
            border-radius: 12px;
        }

        table, th, td {
            border: 1px solid black;
            border-radius: 10px;
        }
    </style>
</head>
<body>

  <%--  <form  action="<c:url value="/addToCart/${product.productId}"/>">--%>

    <%--@elvariable id="product" type="com.ecommerce.entity.Product"--%>
    <form:form action="${pageContext.request.contextPath}/addToCart" method="post"
               modelAttribute="product">
      <table>

        <tr>
           <td rowspan="8">
               <img src="/image/${product.getAttachment().getAttachmentPath()}"
                    height="300" alt="Generic placeholder thumbnail" />
           </td>

                <tr>
              <td>Product Id</td>
              <td>${product.productId}</td>
      </tr>
          <tr>
             <td>Price</td>
              <td>${product.productPrice}</td>
          </tr>
          <tr>
                <td>Stock</td>
                <td>${product.stock}</td>
          </tr>
      <tr>
                <td>Category</td>
                <td>${product.category.categoryName}</td>
      </tr>
          <tr>
                <td>Supplier Id</td>
                <td>${product.supplierId}</td>
          </tr>
          <tr>
                 <td>Description</td>
                  <td>${product.productDesc}</td>
          </tr>
          <tr>
                <td> Quantity
                  <select name="quantity">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                  </select>
                </td>
              <td>
                  <a class="cart-btn" href="<c:url value="/addToCart/${product.productId}"/>" class="btn btn-primary">BUY</a>
           <%--   <input type="submit" value="BUY" class="btn btn-success">--%>
          </td>
        </tr>
      </table>
    </form:form>
    <%--</form>--%>

</body>
</html>
