package com.quintet.todoapp.controller;

import com.quintet.todoapp.model.Address;
import com.quintet.todoapp.model.Role;
import com.quintet.todoapp.model.User;
import com.quintet.todoapp.repository.UserMongoRepo;
import com.quintet.todoapp.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ApplicationController {
    @Autowired
    private UserMongoRepo userRepo;
    @Autowired
    private User user;
    @Autowired
    private Address address;
    @Autowired
    private Role role;

    @GetMapping("/")
    @ResponseBody
    public String test(){
        user.setId(MongoService.generateId());
        user.setName("Ashik Muhammad Shakil");
        user.setEmail("ashikmdshakilpranto@gmail.com");
        user.setMobileNumber("01720024944");
        user.setPassword("123456");
        role.setId(1);
        user.setRole(role);
        userRepo.save(user);
        return "Hello Mongo project !";
    }

    @GetMapping("/getUsers")
    @ResponseBody
    public Role getUsers(){
        return userRepo.findByEmail("ashikmdshakilpranto@gmail.com").getRole();
    }

    @GetMapping("/getMessage")
    @ResponseBody
    public String getMessage(){
        return "Hello this is message";
    }


}
