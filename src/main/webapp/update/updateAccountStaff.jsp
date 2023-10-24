<%--
  Created by IntelliJ IDEA.
  User: nguyendeptraivkl
  Date: 24/10/2023
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Form edit</h1>
<button><a href="/ecommerce">Back to list</a></button>
<form method="post" >
    <input type="hidden" name="id" value="<c:out value='${staff.id}' />">
    <input type="text" name="name" value="<c:out value='${staff.name}' />">
    <input type="text" name="password" value="<c:out value='${staff.password}' />">
    <input type="text" name="email" value="<c:out value='${staff.email}' />">
    <input type="text" name="age" value="<c:out value='${staff.age}' />">
    <input type="text" name="phone_number" value="<c:out value='${staff.phone_number}' />">
    <input type="text" name="address" value="<c:out value='${staff.address}' />">
    <button type="submit">Update</button>
</form>
</body>
</html>
