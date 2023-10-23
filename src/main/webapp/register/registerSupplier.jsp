<%--
  Created by IntelliJ IDEA.
  User: nguyendeptraivkl
  Date: 22/10/2023
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/ecommerce?action=registerSupplier" method="post">
    UserName: <input type="text" name="username"/>
    Password:<input type="text" name="password"/>
    Email:<input type="text" name="email"/>
    Name:<input type="text" name="name">
    Age:<input type="number" name="age"/>
    Phone_Number: <input type="number" name="phone_number">
    Address: <input type="text" name="address">
    <input type="hidden" name="action" value="registerSupplier">
    <input type="submit" value="Dang ki">
</form>
</body>
</html>

