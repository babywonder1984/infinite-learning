package com.example.formdemo.service;


import com.example.formdemo.repository.UserRepo;
import com.example.formdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    public List<User> getAllUser(){
       Iterable<User> loginForms =this.userRepo.findAll();
       loginForms.forEach(loginForm -> System.out.println(loginForm.getUsername()));
        List<User> loginFormsList = new ArrayList<>();
                loginForms.forEach(i -> loginFormsList.add(i));
        return loginFormsList;

    }

}
