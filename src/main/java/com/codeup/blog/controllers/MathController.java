package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add")
    @ResponseBody
    public int math() {
     return x;
    }

    @GetMapping("/subtract")
    @ResponseBody
    public int math() {
        return x;
    }

    @GetMapping("/multiply")
    @ResponseBody
    public int math() {
        return x;
    }

    @GetMapping("/divide")
    @ResponseBody
    public int math() {
        return x;
    }


}
