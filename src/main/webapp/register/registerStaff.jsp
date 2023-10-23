<%--
  Created by IntelliJ IDEA.
  User: chung
  Date: 20/10/2023
  Time: 8:46 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/ecommerce?action=registerStaff" method="post">
    UserName: <input type="text" name="username"/>
    Password:<input type="text" name="password"/>
    Email:<input type="text" name="email"/>
    Name:<input type="text" name="name">
    Age:<input type="number" name="age"/>
    Phone_Number: <input type="number" name="phone_number">
    Address: <input type="text" name="address">
    <input type="hidden" name="action" value="registerStaff">
    <input type="submit" value="Dang ki">
</form>
</body>
</html>
