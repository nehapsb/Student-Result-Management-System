package com.management.studentmanegement.controller;

import com.management.studentmanegement.model.StudentProperties;
import com.management.studentmanegement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody Iterable<StudentProperties> get() {
        return studentService.getStudentDetails();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public @ResponseBody StudentProperties get(@PathVariable(name = "id") Long id) {
        return studentService.getStudentDetails(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody StudentProperties studentProperties) {
        studentService.addStudent(studentProperties);
    }

}
