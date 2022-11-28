<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <div class="container-fluid">
        <div class="row">
                <div class="col-md-9">

                     <%--@elvariable id="userDto" type="com.ecommerce.dto.UserDto"--%>
                     <form:form action="${pageContext.request.contextPath}/views/auth/signup" method="post"
                     modelAttribute="userDto">

                         <div class="form-group">
                              <label for="name"> Name</label>
                              <form:input type="text" cssClass="form-control" id="name" placeholder="Name" path="name" />
                         </div>


                         <div class="form-group">
                             <label for="email"> Email</label>
                             <form:input type="text" cssClass="form-control" id="email" placeholder="email" path="email" />
                         </div>

                         <div class="form-group">
                             <label for="password"> Password</label>
                             <form:input type="text" cssClass="form-control" id="password" placeholder="Password" path="password" />
                         </div>

                         <button type="submit" class="btn btn-primary">Create</button>
                     </form:form>

                </div>

        </div>

    </div>


</body>
</html>
