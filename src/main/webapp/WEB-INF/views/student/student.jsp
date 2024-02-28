<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC - Databinding</title>
    <base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
<h3>SINH VIÊN PTITHCM</h3>
<form action="student/update.htm" modelAttribute="student">
    <div>Họ và tên</div>
    <input name="name" value="${student.name}">

    <div>Điểm trung bình</div>
    <input name="mark" value="${student.mark}">

    <div>Chuyên ngành</div>
    <label>
        <input name="major" type="radio" value="APP" ${student.major == 'APP'?'checked':''}/>
        Ứng dụng phần mềm
    </label>
    <label>
        <input name="major" type="radio" value="WEB" ${student.major == 'WEB'?'checked':''}/>
        Thiết kế trang web
    </label>
</form>

<div>
    <button>Cập nhật</button>
</div>
</body>
</html>
