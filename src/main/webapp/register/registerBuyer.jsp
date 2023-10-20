<%--
  Created by IntelliJ IDEA.
  User: chung
  Date: 19/10/2023
  Time: 3:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/ ecommerce" method="post">
    UserName: <input type="text" name="username"/>
    Password:<input type="text" name="password"/>
    Email:<input type="text" name="email"/>
    Age:<input type="number" name="age"/>
    Phone_Number: <input type="number" name="phone_number">
    Address: <input type="text" name="address">
    <input type="hidden" name="action" value="registerBuyer">
    <input type="submit" value="Đăng Ký">
</form>

</body>
</html>
