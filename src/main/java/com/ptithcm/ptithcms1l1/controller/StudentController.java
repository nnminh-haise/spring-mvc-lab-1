package com.ptithcm.ptithcms1l1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping()
    public String index(ModelMap model) {
        model.addAttribute("message", "Bạn gọi index()");
        return "student-mgr";
    }

    @RequestMapping(params = "btnInsert")
    public String insert(ModelMap model) {
        model.addAttribute("message", "Bạn gọi insert()");
        return "student-mgr";
    }

    @RequestMapping(params = "btnUpdate")
    public String update(ModelMap model) {
        model.addAttribute("message", "Bạn gọi update()");
        return "student-mgr";
    }

    @RequestMapping(params = "btnDelete")
    public String delete(ModelMap model) {
        model.addAttribute("message", "Bạn gọi delete()");
        return "student-mgr";
    }

    @RequestMapping(params = "InkEdit")
    public String edit(ModelMap model) {
        model.addAttribute("message", "Bạn gọi edit()");
        return "student-mgr";
    }
}
