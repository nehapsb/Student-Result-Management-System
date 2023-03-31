package com.management.studentmanegement.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
    public class DemoController {

        @GetMapping(value = "/home")
        public String getString() {
             System.out.println("Reached Here");
            return "home";
        }
    }

