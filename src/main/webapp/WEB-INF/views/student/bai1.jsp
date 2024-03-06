<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC</title>
    <base href="${pageContext.servletContext.contextPath}/">
    <style>
        div {
            display: inline-block;
            text-align: center;
            margin: 5px;
            padding: 5px;
            border: 1px dotted orangered;
            border-radius: 5px;
        }
        img {
            height: auto;
            width: 300px;
        }
    </style>
</head>
<body>
    <h1>EL & JSTL</h1>
    <div>
        <img src="${requestScope["photo"]}">
        <br>
        <strong>${requestScope["name"]}</strong>
        <em>${sessionScope.salary * requestScope["level"]}</em>
    </div>
    <div>
        <img src="${sessionScope["photo"]}">
        <br>
        <strong>${sessionScope["name"]}</strong>
        <em>${sessionScope.salary * sessionScope["level"]}</em>
    </div>
    <div>
        <img src="${applicationScope.photo}">
        <br>
        <strong>${applicationScope.name}</strong>
        <em>${sessionScope.salary * applicationScope.level}</em>
    </div>
</body>
</html>
