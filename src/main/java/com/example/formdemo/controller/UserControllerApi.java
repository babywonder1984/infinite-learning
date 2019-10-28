package com.example.formdemo.controller;

import com.example.formdemo.domain.User;
import com.example.formdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerApi {

    private UserService userService;

    @Autowired
    public  UserControllerApi(UserService userService){
        this.userService=userService;

    }


    @RequestMapping("/api")
    public List<User> getUserInfo(){

        return this.userService.getAllUser() ;


    }




}
