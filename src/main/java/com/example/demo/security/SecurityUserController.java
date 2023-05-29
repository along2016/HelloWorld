package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SecurityUserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public String addUser(){
        return userService.addUser();
    }

    @RequestMapping("/updateUser")
    public String updateUser(){
        return userService.updateUser();
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(){
        return userService.deleteUser();
    }
}
