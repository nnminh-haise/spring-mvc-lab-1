package com.ptithcm.ptithcms1l1.controller;

import com.ptithcm.ptithcms1l1.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private User user;

    @RequestMapping("index")
    public String index(ModelMap model) {
        return "home/index";
    }

    @ModelAttribute("user")
    public User getUser() {
        return this.user;
    }
}
