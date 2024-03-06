# Report lab 4 - EL & JSTL

## Exercise 1

Using EL to get data from the attributes of `ServletContext`, `HttpServletRequest` and `HttpSession`.

Modify the `StudentController` like below:

`StudentController.java`

```java
package com.ptithcm.ptithcms1l1.controller;

import com.ptithcm.ptithcms1l1.bean.Major;
import com.ptithcm.ptithcms1l1.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student-mgr")
public class StudentController {

    @Autowired
    private ServletContext application;

    // Other methods ---

    @RequestMapping("index")
    public String index(
            HttpServletRequest request,
            HttpSession session
    ) {
        application.setAttribute("name", "Nguyen Nhat Minh");
        application.setAttribute("level", 2);

        session.setAttribute("name", "Mai Thuy Quynh Giang");
        session.setAttribute("level", 4);

        request.setAttribute("name", "Le Hoang Khang");
        request.setAttribute("leve", 3);

        session.setAttribute("salary", 1000);
        request.setAttribute("photo", "src/main/resources/img/qwqp.jpeg");

        return "student/index";
    }

    // Other methods ---
}
```

Add a new `bai1.jsp` view into `views/student`

```jsp
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
        <img src="${photo}">
        <br>
        <strong>${name}</strong>
        <em>${salary * level}</em>
    </div>
    <div>
        <img src="${photo}">
        <br>
        <strong>${name}</strong>
        <em>${salary * level}</em>
    </div>
    <div>
        <img src="${photo}">
        <br>
        <strong>${name}</strong>
        <em>${salary * level}</em>
    </div>
</body>
</html>
```

Remember to config the `<base>` tag to the correct page path in order to get the correct image.

The image is stored at `webapp/images`.

Run the server at `student-mgr/index.htm` to see the result:

![](img/Screenshot%202024-03-06%20at%2014.08.45.png)

Update the `index()` method inside the `StudentController` like below:

```java
package com.ptithcm.ptithcms1l1.controller;

import com.ptithcm.ptithcms1l1.bean.Major;
import com.ptithcm.ptithcms1l1.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student-mgr")
public class StudentController {

    @Autowired
    private ServletContext application;

    // Other methods ---

    @RequestMapping(value = "index")
    public String index(
            HttpServletRequest request,
            HttpSession session
    ) {
        application.setAttribute("name", "Nguyen Nhat Minh");
        application.setAttribute("level", 2);
        application.setAttribute("photo", "images/qwqp2.jpeg");

        session.setAttribute("name", "Le Hoang Khang");
        session.setAttribute("level", 4);
        session.setAttribute("photo", "images/qwqp3.jpg");

        request.setAttribute("name", "Mai Thuy Quynh Giang");
        request.setAttribute("level", 3);
        request.setAttribute("photo","images/qwqp.jpeg");

        session.setAttribute("salary", 1000);

        return "student/bai1";
    }

    // Other methods ---
}
```

And update the `bai1.jsp` view:

```jsp
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
```

Go to `/student-mgr/index.htm` to see the result:

![](img/Screenshot%202024-03-06%20at%2014.19.59.png)

---

## Exercise 2

Using EL to get data from Map and Collection

Create new `index2()` method inside the `StudentController`

```java
@Controller
@RequestMapping("student-mgr")
public class StudentController {
    // Other methods ---

    @RequestMapping(value = "index2")
    public String index2(ModelMap model) {
        Student s1 = new Student("Nguyen Van A", 9.5, "Ung dung phan mem");
        Student s2 = new Student("Nguyen Van B", 8.5, "Thiet ke trang web");
        Student s3 = new Student("Nguyen Van C", 7.5, "Thiet ke trang web");

        List<Student> list = List.of(s2, s3);

        Map<String, Student> map = new HashMap<>();
        map.put("NV_B", s2);
        map.put("NV_C", s3);

        model.addAttribute("bean", s1);
        model.addAttribute("list", list);
        model.addAttribute("map", map);

        return "student/index2";
    }

    // Other methods ---
}
```

Add a new `index2.jsp` view inside the `views/student`:

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    </ul>
    <ul>
        <li><label>Họ và tên: </label>${list[0].name}</li>
        <li><label>Điểm TB: </label>${list[0].mark}</li>
        <li><label>Chuyên ngành: </label>${list[0].major}</li>
    </ul>
    <ul>
        <li><label>Họ và tên: </label>${map.NV_C.name}</li>
        <li><label>Điểm TB: </label>${map.NV_C.mark}</li>
        <li><label>Chuyên ngành: </label>${map.NV_C.major}</li>
    </ul>
</body>
</html>
```

Go to `/student-mgr/index2.htm` to see the result

![](img/Screenshot%202024-03-06%20at%2014.50.00.png)

---

## Exercise 3

Intergrate the JSTL into views.

### Add new dependency into pom.xml

Add the below dependency into your pom.xml file.

```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>
```

Inside your `index2.jsp` view, add the below tablib directive:

```jsp
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
```

Also, using the `<c:if>` tag to add an if statement into your view:

```jsp
<c:if test="${your_syntax.mark >= 9}">
    <li><label>Danh hiệu:</label> ONG VÀNG</li>
</c:if>
```

The `index2.jsp` view should look like this:

```jsp
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
    </ul>
    <ul>
        <li><label>Họ và tên: </label>${list[0].name}</li>
        <li><label>Điểm TB: </label>${list[0].mark}</li>
        <li><label>Chuyên ngành: </label>${list[0].major}</li>
        <c:if test="${list[0].mark >= 9}">
            <li><label>Danh hiệu:</label> ONG VÀNG</li>
        </c:if>
    </ul>
    <ul>
        <li><label>Họ và tên: </label>${map.NV_C.name}</li>
        <li><label>Điểm TB: </label>${map.NV_C.mark}</li>
        <li><label>Chuyên ngành: </label>${map.NV_C.major}</li>
        <c:if test="${map.NV_C.mark >= 9}">
            <li><label>Danh hiệu:</label> ONG VÀNG</li>
        </c:if>
    </ul>
</body>
</html>
```

Go to `/student-mgr/index2.htm` to see result:

![](img/Screenshot%202024-03-06%20at%2014.59.44.png)

---

## Exercise 4

Add ranking for each student into your view.

Modify your view like below:

```jsp
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
```

Go to `/student-mgr/index2.htm` to see result:

![](img/Screenshot%202024-03-06%20at%2015.10.16.png)

---

## Exercise 5


