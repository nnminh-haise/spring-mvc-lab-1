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

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String showForm() {
        return "student/form";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String saveData(HttpServletRequest request) {
        String name = request.getParameter("name");
        String mark = request.getParameter("mark");
        String major = request.getParameter("major");

        request.setAttribute("name", name);
        request.setAttribute("mark", mark);
        request.setAttribute("major", major);

        return "student/success";
    }

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

    @RequestMapping(params = "btnInsert")
    public String insert(
            ModelMap model,
            @RequestParam("name") String name,
            @RequestParam("mark") Double mark,
            @RequestParam("major") String major
    ) {
        model.addAttribute("name", name);
        model.addAttribute("mark", mark);
        model.addAttribute("major", major);
        return "student/success";
    }

    @RequestMapping(params = "btnUpdate")
    public String update(ModelMap model, Student student) {
        model.addAttribute("student", student);
        return "student/success2";
    }

    @RequestMapping(params = "btnDelete")
    public String delete(ModelMap model) {
        model.addAttribute("message", "Bạn gọi delete()");
        return "student/student-mgr";
    }

    @RequestMapping(params = "InkEdit")
    public String edit(ModelMap model) {
        model.addAttribute("message", "Bạn gọi edit()");
        return "student/student-mgr";
    }

    @ModelAttribute("majors")
    public List<Major> getMajors() {
        List<Major> mj = new ArrayList<>();
        mj.add(new Major("APP", "Ứng dụng phần mềm"));
        mj.add(new Major("ID", "Information Technology"));
        mj.add(new Major("ML", "Multi Media"));
        mj.add(new Major("IOS", "IOS"));
        return mj;
    }
}
