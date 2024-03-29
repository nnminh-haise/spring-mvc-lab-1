<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>Spring MVC</title>
    <base href="${pageContext.servletContext.contextPath}/">
    <style>
        li {
            list-style: none;
            line-height: 25px;
        }
        li>label {
            display: inline-block;
            text-align: right;
            width: 110px;
            font-variant: small-caps;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h1>EL & JSTL</h1>
    <ul>
        <li><label>Họ và tên: </label>${bean.name}</li>
        <li><label>Điểm TB: </label>${bean.mark}</li>
        <li><label>Chuyên ngành: </label>${bean.major}</li>
        <c:if test="${bean.mark >= 9}">
            <li><label>Danh hiệu:</label> ONG VÀNG</li>
        </c:if>
        <li>
            <label>Xếp loại: </label>
            <c:choose>
                <c:when test="${bean.mark < 5}">Yếu</c:when>
                <c:when test="${bean.mark < 6.5}">Trung bình</c:when>
                <c:when test="${bean.mark < 7.5}">Khá</c:when>
                <c:when test="${bean.mark < 9}">Giỏi</c:when>
                <c:otherwise>Xuất sắc</c:otherwise>
            </c:choose>
        </li>
    </ul>
    <ul>
        <li><label>Họ và tên: </label>${list[0].name}</li>
        <li><label>Điểm TB: </label>${list[0].mark}</li>
        <li><label>Chuyên ngành: </label>${list[0].major}</li>
        <c:if test="${list[0].mark >= 9}">
            <li><label>Danh hiệu:</label> ONG VÀNG</li>
        </c:if>
        <li>
            <label>Xếp loại: </label>
            <c:choose>
                <c:when test="${list[0].mark < 5}">Yếu</c:when>
                <c:when test="${list[0].mark < 6.5}">Trung bình</c:when>
                <c:when test="${list[0].mark < 7.5}">Khá</c:when>
                <c:when test="${list[0].mark < 9}">Giỏi</c:when>
                <c:otherwise>Xuất sắc</c:otherwise>
            </c:choose>
        </li>
    </ul>
    <ul>
        <li><label>Họ và tên: </label>${map.NV_C.name}</li>
        <li><label>Điểm TB: </label>${map.NV_C.mark}</li>
        <li><label>Chuyên ngành: </label>${map.NV_C.major}</li>
        <c:if test="${map.NV_C.mark >= 9}">
            <li><label>Danh hiệu:</label> ONG VÀNG</li>
        </c:if>
        <li>
            <label>Xếp loại: </label>
            <c:choose>
                <c:when test="${map.NV_C.mark < 5}">Yếu</c:when>
                <c:when test="${map.NV_C.mark < 6.5}">Trung bình</c:when>
                <c:when test="${map.NV_C.mark < 7.5}">Khá</c:when>
                <c:when test="${map.NV_C.mark < 9}">Giỏi</c:when>
                <c:otherwise>Xuất sắc</c:otherwise>
            </c:choose>
        </li>
    </ul>
</body>
</html>
