<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Total Product Display</title>
</head>
<body>

    <form action="<c:url value="/addToCart/${product.productId}"/>">
      <table class="table-bordered">

        <tr>
           <td rowspan="8">
               <img src="<c:url value="/image/${product.productId}.jpg" />" height="300" alt="Generic placeholder thumbnail" />
           </td>

              <td>Product Id</td>
              <td>${product.productId}</td>

             <td>Price</td>
              <td>${product.price}</td>

                <td>Stock</td>
                <td>${product.stock}</td>

                <td>Category</td>
                <td>${product.category}</td>

                <td>Supplier Id</td>
                <td>${product.supplierId}</td>

                 <td>Description</td>
                  <td>${product.productDesc}</td>

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

          <td><input type="submit" value="BUY" class="btn btn-success"></td>
        </tr>

      </table>

    </form>

</body>
</html>
