<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment</title>
</head>
<body>

      <div class="container">

          <form action="<c:url value="/receipt"/>" method="post">

             <table class="table table-bordered" width="50%" align="center">
                <tr  class="success">
                   <td colspan="2">
                     <centr> Payment Detail </centr>
                   </td>
                </tr>
               <tr class="info">
                   <td  colspan="2">
                       <center>
                          <input type="radio" name="rd" value="cc">Credit Car
                         <input type="radio" name="rd" value="cod">Cash On Delivery
                       </center>
                   </td>
               </tr>

               <tr class="warning">
                  <td>Card Number</td>
                 <td> <input type="text" name="cardno"></td>
               </tr>

               <tr class="warning">
                  <td>Valid<input type="text" name="valid"></td>
                 <td>CVV<input type="text" name="CVV"></td>
               </tr>

               <tr class="warning">
                 <td><input type="text" name="name"></td>
               </tr>

               <tr class="success">
                 <td colspan="2"> <center><input type="submit" value="Pay" class="btn btn-success"></center></td>
               </tr>
             </table>
          </form>

      </div>
</body>
</html>
