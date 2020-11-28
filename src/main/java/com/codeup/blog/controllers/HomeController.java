package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "This is the landing page!";
    }

// VIEWS
//      This example uses Thymeleaf (a templating language for views); see dependency in POM.xml

    @GetMapping("/home")
    public String welcome(){
        return "/home";
    }

}
