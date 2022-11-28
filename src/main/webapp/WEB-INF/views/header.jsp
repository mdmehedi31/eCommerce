<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
  <title>${pageinfo}-HalalBazar.com</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">HALALBAZAR</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="Login">LOGIN</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="signup">Sign Up</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="createProduct">Product</a>
        </li>
       <li  class="nav-item">
        <a class="nav-link" href="showProduct">Show Product</a>
        </li>
          <li  class="nav-item">
          <a class="nav-link" href=productDisplay> Product Catalog</a>
      </li>
        <li class="nav-item">
          <a class="nav-link" href="supplier">Supplier</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="showSupplier">Show Supplier</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="category">Category</a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="showCategory">Show Category</a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="Cart">Cart</a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="payment">Payment</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

</body>

</html>