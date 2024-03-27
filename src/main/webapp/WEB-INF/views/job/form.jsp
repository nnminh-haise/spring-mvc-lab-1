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
    </style>
</head>
<body>
    <h2>Nộp đơn xin việc</h2>
    ${message}
    <form action="job/apply.htm" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <div>Họ và tên ứng viên</div>
            <input type="text" name="fullname">
        </div>

        <div class="form-group">
            <div>Hình ảnh</div>
            <input type="file" name="photo">
        </div>

        <div class="form-group">
            <div>Hồ sơ xin việc</div>
            <input type="file" name="cv">
        </div>

        <div class="form-group">
            <button>Submit</button>
        </div>
    </form>
</body>
</html>
