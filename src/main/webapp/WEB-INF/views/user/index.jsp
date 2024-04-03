<%--
  Created by IntelliJ IDEA.
  User: nnminh
  Date: 03/04/2024
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User</title>
</head>
<body>
  <table class="table table-hover">
    <tr>
      <th>Username</th>
      <th>Password</th>
      <th>Fullname</th>
      <th></th>
    </tr>
    <c:forEach var="u" items="${users}">
      <tr>
        <td>${u.username}</td>
        <td>${u.password}</td>
        <td>${u.fullname}</td>
        <td>
          <a href="user/delete/${u.username}.htm"></a>
        </td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
