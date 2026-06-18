package com.studyabroad.controller;

import com.studyabroad.model.AbroadCourse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.studyabroad.business.ExcelWriter;

@Controller
public class StudentFormController {

    @GetMapping("/courses")
    public String showForm(Model model) {
        model.addAttribute("course", new AbroadCourse());
        return "studentform";
    }

    @PostMapping("/courses")
    public String saveCourse(@ModelAttribute AbroadCourse course) {
        ExcelWriter writer = new ExcelWriter(); 
        writer.writeAbroadCourse(course);
        return "redirect:/courses";
    }
} 