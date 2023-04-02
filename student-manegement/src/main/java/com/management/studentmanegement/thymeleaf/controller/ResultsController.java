package com.management.studentmanegement.thymeleaf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.management.studentmanegement.exception.InvalidDataException;
import com.management.studentmanegement.model.course.CourseProperties;
import com.management.studentmanegement.model.Grade;
import com.management.studentmanegement.model.result.ResultDataModel;
import com.management.studentmanegement.model.result.ResultOptions;
import com.management.studentmanegement.model.student.StudentProperties;
import com.management.studentmanegement.service.CourseService;
import com.management.studentmanegement.service.ResultService;
import com.management.studentmanegement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
    public class ResultsController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private ResultService resultService;

    @RequestMapping(value = "/result_view")
    public String getAllResults(Model model) {
        Iterable<ResultDataModel> results = resultService.getAllResultDetails();
        model.addAttribute("results", results);
        System.out.println("Reached Here in Results");
        return "result-view";
    }
    @RequestMapping(value = "/result_create_page")
    public String resultCreatePage(Model model) {
        System.out.println("Reached Here in create page of Results");
        Iterable<StudentProperties> studentProperties = studentService.getStudentDetails();
        model.addAttribute("students", studentProperties);
        Iterable<CourseProperties> courseProperties = courseService.getAllCourses();
        model.addAttribute("courses", courseProperties);
        List<Grade> gradeList = resultService.getResultOptions();
        System.out.println("Grades: "+gradeList);
        model.addAttribute("resultOptions", gradeList);
        return "result-create";
    }

    @RequestMapping(value = "/result_create")
    public String createResultGet(@RequestParam Long studentId, @RequestParam Long courseId, @RequestParam Grade grade, Model model) throws JsonProcessingException {
        System.out.println("Reached here in GET of create result.");
        ResultDataModel resultDataModel = ResultDataModel.builder().studentId(studentId).courseId(courseId).grade(grade).build();
        try {
            resultService.addResult(resultDataModel);
        } catch (InvalidDataException exception) {
            model.addAttribute("errorResult", exception.getMessage());
            return "result-create";
        }
        System.out.println("Reached Here in create result");
        return getAllResults(model);
    }
    }

