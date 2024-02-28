<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Spring MVC - Databinding</title>
  <base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
  <h3>SINH VIÊN PTITHCM</h3>
  <form:form action="student/update.htm" modelAttribute="student">
    <div>Họ và tên</div>
    <form:input path="name"/>

    <div>Điểm</div>
    <form:input path="mark"/>

    <div>Chuyên ngành</div>
    <form:select path="major" items="${majors}" itemValue="id" itemLabel="name"/>
  </form:form>

  <div>
    <button>Cập nhật</button>
  </div>
</body>
</html>
