<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Confirm</title>
</head>
<body>
        <div class="container">
            <table class="table table-bordered">
                 <tr class="danger">
                     <td colspan="6">
                         <center>Order Items</center>
                     </td>
                 </tr>

                <tr>
                    <td>Product Id</td>
                    <td>Product Name</td>
                    <td>Quantity</td>
                    <td>Price</td>
                    <td>SubTotal</td>
                </tr>

                <c:forEach items="${cartItemList}" var="cartItem">
                    <tr class="info">
                         <td>${cartItem.productId}</td>
                         <td>${cartItem.productName}</td>
                         <td>${cartItem.quantity}</td>
                         <td>${cartItem.price}</td>
                         <td>${cartItem.price * cartItem.quantity}</td>
                    </tr>
                </c:forEach>

                <tr class="warning">
                    <td colspan="4">Total Purchases Amount</td>
                    <td colspan="1">${grandTotal}/-</td>
                </tr>

                <tr class="warning">
                    <td colspan="5">Shipping Address</td>
                </tr>

                <form action="<c:url value="/UpdateAddr"/>" method="post">
                    <tr class="info">

                        <td> Address </td>
                        <td colspan="3">
                            <textarea name="addr" cols="32" rows="1"> ${addr}</textarea>
                        </td>

                        <input type="submit" value="Update Address" class="btn btn-success">
                    </tr>
                </form>

                <tr class="warning">
                    <td colspan="5"></td>
                </tr>
                <tr class="info">
                    <td colspan="2">
                         <center>
                             <a href="<c:url value="/Cart"/>" class="btn btn-success">Modify Cart</a>
                         </center>
                    </td>
                    <td colspan="3">
                        <center>
                            <a href="<c:url value="/payment"/>"  class="btn btn-success">Order Confirm</a>
                        </center>
                    </td>
                </tr>
            </table>
        </div>
</body>
</html>
