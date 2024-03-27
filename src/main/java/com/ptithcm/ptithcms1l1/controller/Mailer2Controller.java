package com.ptithcm.ptithcms1l1.controller;

import com.ptithcm.ptithcms1l1.service.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.internet.MimeMessage;

@Controller
@RequestMapping("/mailer2")
public class Mailer2Controller {
    @Autowired
    private Mailer mailer;

    @RequestMapping("form")
    public String index() {
        return "mailer/form";
    }

    @RequestMapping("send")
    public String send(ModelMap model,
                       @RequestParam("from") String from,
                       @RequestParam("to") String to,
                       @RequestParam("subject") String subject,
                       @RequestParam("body") String body) {
        try {
            mailer.send(from, to, subject, body);

            model.addAttribute("message", "Email sent successfully!");
        } catch (Exception e) {
            System.out.println("LOG: " + e.getMessage());
            model.addAttribute("message", "Failed to send email!");
        }

        return "mailer/form";
    }
}
