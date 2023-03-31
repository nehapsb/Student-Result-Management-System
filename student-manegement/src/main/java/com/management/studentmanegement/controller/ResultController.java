package com.management.studentmanegement.controller;

import com.management.studentmanegement.model.CourseProperties;
import com.management.studentmanegement.model.StudentProperties;
import com.management.studentmanegement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public Iterable<CourseProperties> get() {
        return courseService.getAllCourses();
    }

    @GetMapping(value = "/id")
    public CourseProperties get(@RequestParam Long id) {
        return courseService.getCourse(id);
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody CourseProperties courseProperties) {
        courseService.addCourse(courseProperties);
    }


}