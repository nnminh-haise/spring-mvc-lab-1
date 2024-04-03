package com.ptithcm.ptithcms1l1.controller;

import com.ptithcm.ptithcms1l1.model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Transactional
@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("index")
    public String index(ModelMap model) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "FROM User";
        Query query = session.createQuery(hql);
        List<User> users = query.list();
        model.addAttribute("users", users);
        return "user/index";
    }

    @RequestMapping(value="insert", method = RequestMethod.GET)
    public String insert(ModelMap model) {
        model.addAttribute("user", new User());
        return "user/insert";
    }

    @RequestMapping(value="insert", method = RequestMethod.POST)
    public String insert(ModelMap model, @ModelAttribute("user") User user) {
        Session session = sessionFactory.openSession();

        Transaction t = session.beginTransaction();
        try {
            session.save(user);
            t.commit();
            model.addAttribute("message", "Insert Success!");

        } catch (Exception e) {
            t.rollback();
            model.addAttribute("message", "Insert Failed!");
        } finally {
            session.close();
        }
        return "user/insert";
    }

    @RequestMapping(value="update", method = RequestMethod.GET)
    public String update(ModelMap model) {
        model.addAttribute("user", new User());
        return "user/update";
    }

    @RequestMapping(value="update", method = RequestMethod.POST)
    public String update(ModelMap model, @ModelAttribute("user") User user) {
        Session session = sessionFactory.openSession();

        Transaction t = session.beginTransaction();
        try {
            session.update(user);
            t.commit();
            model.addAttribute("message", "Update Success!");

        } catch (Exception e) {
            t.rollback();
            model.addAttribute("message", "Update Failed!");
        } finally {
            session.close();
        }
        return "user/update";
    }

    @RequestMapping(value="delete", method = RequestMethod.GET)
    public String delete(ModelMap model) {
        model.addAttribute("user", new User());
        return "user/delete";
    }

    @RequestMapping(value="delete", method = RequestMethod.POST)
    public String delete(ModelMap model, @ModelAttribute("user") User user) {
        Session session = sessionFactory.openSession();

        Transaction t = session.beginTransaction();
        try {
            session.delete(user);
            t.commit();
            model.addAttribute("message", "Delete Success!");
        } catch (Exception e) {
            t.rollback();
            model.addAttribute("message", "Delete Failed!");
        } finally {
            session.close();
        }
        return "user/delete";
    }
}
