<%--
  Created by IntelliJ IDEA.
  User: nnminh
  Date: 03/04/2024
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Update User</title>
</head>
<body>
  ${message}
  <form:form action="update.htm" modelAttribute="user" method="post">
    <div>
      <label>Username</label>
      <form:input path="username"/>
    </div>
    <div>
      <label>Password</label>
      <form:input path="password"/>
    </div>
    <div>
      <label>Fullname</label>
      <form:input path="fullname"/>
    </div>
    <div>
      <button class="btn btn-default">Update</button>
    </div>
  </form:form>
</body>
</html>
