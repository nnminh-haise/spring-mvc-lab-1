<%--
  Created by IntelliJ IDEA.
  User: nnminh
  Date: 25/03/2024
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8"/>
  <title>Dependency Injection</title>
  <style>
    .form-group {
      margin: 10px;
    }
  </style>
</head>
<body>
  <form>
    <div class="form-group">
      <div>Username</div>
      <input name="id" value="${user.username}">
    </div>

    <div class="form-group">
      <div>Password</div>
      <input name="id" value="${user.password}">
    </div>

    <div class="form-group">
      <button>Login</button>
    </div>
  </form>
</body>
</html>
