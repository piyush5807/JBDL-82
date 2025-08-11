package com.example.major_project.controllers;

import com.example.major_project.dto.CreateUserDTO;
import com.example.major_project.models.User;
import com.example.major_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("")
    public User createUser(@RequestBody CreateUserDTO createUserDTO){
        return this.userService.create(createUserDTO);
    }
}
