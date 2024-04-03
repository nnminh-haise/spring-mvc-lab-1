package com.ptithcm.ptithcms1l1.controller;

import com.ptithcm.ptithcms1l1.bean.UserLab5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private UserLab5 userLab5;

    @RequestMapping("index")
    public String index(ModelMap model) {
        return "home/index";
    }

    @ModelAttribute("user")
    public UserLab5 getUser() {
        return this.userLab5;
    }
}
