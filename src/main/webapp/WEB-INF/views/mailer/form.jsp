<%--
  Created by IntelliJ IDEA.
  User: nnminh
  Date: 26/03/2024
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <base href="${pageContext.servletContext.contextPath}/">
  <meta charset="utf-8" />
  <title>Exercise 3 - Send email</title>
</head>
<body>
  ${message}
  <form action="mailer/send.htm" method="post">
    <p><input name="from" placeholder="From"></p>
    <p><input name="to" placeholder="To"></p>
    <p><input name="subject" placeholder="Subject"></p>
    <p><textarea name="body" placeholder="Body" rows="3" cols="30"></textarea></p>
    <button>Send</button>
  </form>
</body>
</html>
