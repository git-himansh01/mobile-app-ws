package com.learning.mobileappws.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
    @GetMapping
    public String getUser(){
        return "Get User was called";
    }
    @PostMapping
    public String createUser(){
        return "Create User was called";
    }
    @PutMapping
    public String updateUser(){
        return "Update user was called";
    }
    @DeleteMapping
    public String deletUser(){
        return "Delete user was called";
    }

}
