package com.management.studentmanegement.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
    public class DemoController {

        @RequestMapping(value = "/")
        public String getString() {
             System.out.println("Reached Here");
            return "index";
        }
    }

