package com.management.studentmanegement.controller;

import com.management.studentmanegement.model.StudentProperties;
import com.management.studentmanegement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Iterable<StudentProperties> get() {
        return studentService.getStudentDetails();
    }

    @GetMapping(value = "/id")
    public StudentProperties get(@RequestParam Long id) {
        return studentService.getStudentDetails(id);
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody StudentProperties studentProperties) {
        studentService.addStudent(studentProperties);
    }


}
