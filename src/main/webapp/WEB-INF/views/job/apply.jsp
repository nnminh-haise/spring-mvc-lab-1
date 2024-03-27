<%--
  Created by IntelliJ IDEA.
  User: nnminh
  Date: 26/03/2024
  Time: 00:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.servletContext.contextPath}/">
    <meta charset="utf-8" />
    <title>Exercise 2 - Upload file</title>
    <style>
        .form-group {
            margin: 10px;
        }
        img {
            height: 300px;
            width: auto;
        }
    </style>
</head>
<body>
    <div>
        <h3>Thông tin cá nhân</h3>
        <img src="files/${photo_name}">
        <br>
        <h3>${param.fullname}</h3>
    </div>

    <div>
        <h3>Hồ sơ xin việc</h3>
        <ul>
            <li>File name: ${cv_name}</li>
            <li>File type: ${cv_type}</li>
            <li>File size: ${cv_size}</li>
        </ul>
    </div>
</body>
</html>
