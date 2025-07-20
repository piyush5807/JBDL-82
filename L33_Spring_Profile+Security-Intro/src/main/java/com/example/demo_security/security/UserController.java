package com.example.demo_security.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public String getUser(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("/user-by-email")
    public String getUserByEmail(@RequestParam("email") String email){
        return "hello " + email;
    }
}
