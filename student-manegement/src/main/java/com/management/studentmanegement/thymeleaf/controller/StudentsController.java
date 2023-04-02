package com.management.studentmanegement.thymeleaf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.studentmanegement.exception.InvalidDataException;
import com.management.studentmanegement.model.student.StudentProperties;
import com.management.studentmanegement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
    public class StudentsController {
    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/")
    public String defaultCall(Model model) {
        return "home";
    }

    @RequestMapping(value = "/home")
    public String home(Model model) {
        System.out.println("Reached Here");
        return "home";
    }

    @RequestMapping(value = "/student_view")
    public String getString(Model model) {
        Iterable<StudentProperties> students = studentService.getStudentDetails();
        model.addAttribute("students", students);
        System.out.println("Reached Here in students"+students);
        return "student-view";
    }
    @RequestMapping(value = "/student_create_page")
    public String studentCreatePage(Model model) {
        System.out.println("Reached Here in create page of student");
        return "student-create";
    }

    @RequestMapping(value = "/student_create")
    public String createStudentGet(@RequestParam String fname, @RequestParam String lname, @RequestParam String dob, Model model) throws JsonProcessingException {
        System.out.println("Reached here in GET of create student.");
        StudentProperties studentProperties = StudentProperties.builder().firstName(fname).lastName(lname).dateOfBirth(dob).build();
        System.out.println("Adding Students as: "+studentProperties.toString());
        try {
            studentService.addStudent(studentProperties);
        } catch (InvalidDataException exception) {
            model.addAttribute("errorStudents", exception.getMessage());
            return "student-create";
        }
        System.out.println("Reached Here in create student");
        return getString(model);
    }

    @GetMapping("/error")
    public String error(Model model) {
        model.addAttribute("errors", "Some Error occurred.");
        return home(model);
    }

    }

