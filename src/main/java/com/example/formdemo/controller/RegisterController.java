package com.example.formdemo.controller;

import com.example.formdemo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @GetMapping
    public String register(){

        return "register";
    }

    @PostMapping
    public String formProcess(User user){
        System.out.println("username:"+ user.getUsername());
        System.out.println("password:"+ user.getPassword());
        return "redirect:/login";

    }


}
