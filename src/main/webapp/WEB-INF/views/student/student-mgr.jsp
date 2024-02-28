<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student manager</title>
</head>
<body>
    <h1>STUDENT MANAGER</h1>
    <form action="student-mgr.htm" method="post">
        ${message}
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

        <hr>
        <button name="btnInsert">Thêm</button>
        <button name="btnUpdate">Cập nhật</button>
        <button name="btnDelete">Xóa</button>
        <button name="btnReset">Nhập lại</button>
    </form>
    <hr>
    <table border="1" style="width: 100%">
        <tr>
            <th>Họ và tên</th>
            <th>Điểm TB</th>
            <th>Chuyên ngành</th>
            <th></th>
        </tr>
        <tr>
            <td>Lê Phạm Tuấn Kiệt</td>
            <td>8.5</td>
            <td>CNTT</td>
            <td><a href="student-mgr.htm?InkEdit">Sửa</a></td>
        </tr>
        <tr>
            <td>Bùi Minh Nhựt</td>
            <td>7.5</td>
            <td>MUL</td>
            <td><a href="student-mgr.htm?InkEdit">Sửa</a></td>
        </tr>
    </table>
</body>
</html>
