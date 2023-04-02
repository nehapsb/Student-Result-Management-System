package com.management.studentmanegement.thymeleaf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.management.studentmanegement.model.course.CourseProperties;
import com.management.studentmanegement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
    public class CoursesController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/course_view")
    public String getAllCourses(Model model) throws JsonProcessingException {
        Iterable<CourseProperties> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        System.out.println("Reached Here in Courses");
        return "course-view";
    }
    @RequestMapping(value = "/course_create_page")
    public String courseCreatePage(Model model) {
        System.out.println("Reached Here in create page of student");
        return "course-create";
    }

    @RequestMapping(value = "/course_create")
    public String createCourseGet(@RequestParam String courseName, Model model) throws JsonProcessingException {
        System.out.println("Reached here in GET of create student.");
        CourseProperties courseProperties = CourseProperties.builder().courseName(courseName).build();
        System.out.println("Adding Courses as: "+courseProperties.toString());
        courseService.addCourse(courseProperties);
        System.out.println("Reached Here in create student");
        return getAllCourses(model);
    }

    }

