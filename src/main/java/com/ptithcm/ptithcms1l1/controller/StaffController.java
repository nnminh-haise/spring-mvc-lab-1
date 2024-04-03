package com.ptithcm.ptithcms1l1.controller;

import com.ptithcm.ptithcms1l1.model.Staff;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("staff")
public class StaffController {
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value ="index", method= RequestMethod.GET)
    public String index(ModelMap model) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "FROM Staff";
        Query query = session.createQuery(hql);
        List<Staff> staffs = query.list();
        model.addAttribute("staffs", staffs);
        return "staff/index";
    }
}
