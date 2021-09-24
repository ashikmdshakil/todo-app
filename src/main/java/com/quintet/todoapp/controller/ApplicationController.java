package com.quintet.todoapp.controller;

import com.quintet.todoapp.model.Address;
import com.quintet.todoapp.model.Role;
import com.quintet.todoapp.model.User;
import com.quintet.todoapp.repository.UserMongoRepo;
import com.quintet.todoapp.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDateTime;
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
    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/userRegistration")
    @ResponseBody
    public String test(@RequestBody User user){
        String status = null;
        try {
            user.setId(MongoService.generateId());
            user.setPassword(encoder.encode(user.getPassword()));
            role.setId(1);
            user.setRole(role);
            userRepo.save(user);
            status = "success";
        } catch (Exception e) {
            status = "failed";
        }
        return status;
    }

    @GetMapping(value = "login")
    @ResponseBody
    public Principal login(Principal userPrincipal ) {
        return userPrincipal;
    }

    @GetMapping("/getUsers")
    @ResponseBody
    public Role getUsers(){
        return userRepo.findByEmail("ashikmdshakilpranto@gmail.com").getRole();
    }



}
