package com.ptithcm.ptithcms1l1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;

@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    private ServletContext context;

    @RequestMapping("/form")
    public String form() {
        return "job/form";
    }

    @RequestMapping("/apply")
    public String apply(
            ModelMap model,
            @RequestParam("fullname") String fullname,
            @RequestParam("cv") MultipartFile cv,
            @RequestParam("photo") MultipartFile photo) {
        if (photo.isEmpty() || cv.isEmpty()) {
            model.addAttribute("message", "Vui lòng chọn file!");
        }
        else {
            try {
                String photoPath = context.getRealPath(photo.getOriginalFilename());
                photo.transferTo(new File(photoPath));

                String cvPath = context.getRealPath("/files/" + cv.getOriginalFilename());
                cv.transferTo(new File(cvPath));

                model.addAttribute("photo_name", photo.getOriginalFilename());
                model.addAttribute("cv_name", cv.getOriginalFilename());
                model.addAttribute("cv_type", cv.getContentType());
                model.addAttribute("cv_size", cv.getSize());

                return "job/apply";

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
                model.addAttribute("message", "Lỗi lưu file!");
            }
        }

        return "job/form";
    }
}
