package com.studyabroad.controller;

import com.studyabroad.model.AbroadCourse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.studyabroad.business.ExcelWriter;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class StudentFormController {

    private final ExcelWriter excelWriter;

    @Autowired
    public StudentFormController(ExcelWriter excelWriter) {
        this.excelWriter = excelWriter;
    }

    @GetMapping("/courses")
    public String showForm(Model model) {
        model.addAttribute("course", new AbroadCourse());
        return "studentform";
    }

    @PostMapping("/courses")
    public String saveCourse(@ModelAttribute AbroadCourse course) {
        try {
            excelWriter.writeAbroadCourse(course);
            return "redirect:/courses?success=true";
        } catch (Exception e) {
            return "redirect:/courses?error=true";
        }
    }
} 