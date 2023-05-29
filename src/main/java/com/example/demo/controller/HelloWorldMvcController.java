package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldMvcController {

    @RequestMapping("/helloworld")
    public String helloWorld(Model model){
        model.addAttribute("mav", "Hello,Spring Boot!我是 MVC 结构");
        return "example/hello";
    }
}
