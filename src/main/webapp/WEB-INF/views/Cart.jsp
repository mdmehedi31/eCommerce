<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"  %>
<html>
<head>
    <title>Add To Cart</title>
</head>
<body>

      <div class="container">
          <table class="table table-bordered">

            <tr class="danger">
                  <td colspan="6"><center>Wishlist</center>
                  </td></tr>
            <tr>
            <td>Product Id</td>
            <td>Product Name</td>
            <td>Quantity</td>
            <td>Price</td>
            <td>Sub Total</td>
            <td>Operation</td>
            </tr>


            <c:forEach items="${cartItemList}" var="carItem">
               <form action="<c:url value="/updateCartItem/${carItem.cartItemUd}"/>" method="post">
                 <tr class="info">
                   <td>${cartItem.productId}</td>
                   <td>${cartItem.productName}</td>
                   <td><input type="text" value="${cartItem.quantity}" name="quantity"></td>
                   <td>${carItem.price}</td>
                  <td>${carItem.price * cartItem.quantity}</td>
                   <td>
                     <input type="submit" value="Update" btn="btn-success">
                     <a href="<c:url value="/deleteCartItem/${carItem.cartItemId}" />" class="btn bt-danger">Delete</a>
                   </td>
                 </tr>
            </c:forEach>

                   <tr class="warning">
                       <td colspan="4"> Total Purchase Amount</td>
                       <td colspan="2">${grandTotal}</td>
                   </tr>
                   <tr class="info">
                    <td colspan="3">
                        <center>
                            <a href="productDisplay" class="btn btn-success"> Continue Your Shopping</a>
                        </center>
                    </td>

                       <td colspan="3">
                           <center> <a href="checkout" class="btn btn-success"> Check Out</a> </center>
                       </td>
                   </tr>
          </table>
      </div>

</body>
</html>
