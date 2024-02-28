package com.ptithcm.ptithcms1l1.controller;

import com.ptithcm.ptithcms1l1.bean.Major;
import com.ptithcm.ptithcms1l1.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student-mgr")
public class StudentController {
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

    @RequestMapping("index")
    public String index(ModelMap model) {
        Student student = new Student("Nguyễn Văn Tèo", 9.5, "WEB");
        model.addAttribute("student", student);
        return "student/student2";
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
