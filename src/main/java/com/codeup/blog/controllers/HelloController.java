package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// CONTROLLERS

// Example 1: My First Controller

// @Controller 	    : define a class as a controller
// @GetMapping      : defines a method that should be invoked when a GET request is received for the specified URI
// @ResponseBody	: tell Spring that whatever is returned from this method should be the body of our response.

@Controller
class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

// Example 2: Path Variables

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

// Example 3:
//      @RequestMapping : longer version of @GetMapping

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }

}
