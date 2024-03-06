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


