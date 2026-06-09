package com.studyabroad.controller;

import com.studyabroad.model.AbroadCourse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentFormController {

    private List<AbroadCourse> courses = new ArrayList<>();

    @GetMapping("/courses")
    public String showForm(Model model) {
        model.addAttribute("course", new AbroadCourse());
        model.addAttribute("courses", courses);
        return "course-form";
    }

    @PostMapping("/courses")
    public String saveCourse(@ModelAttribute AbroadCourse course) {
        courses.add(course);
        return "redirect:/courses";
    }
}