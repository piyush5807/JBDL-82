package com.example.demo_security.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public String getUser(@RequestParam("name") String name){

//        SecurityContext context = SecurityContextHolder.getContext();
//        Authentication authentication = context.getAuthentication();
//        User user = (User) authentication.getPrincipal();
        return "hello " + name;
    }

    @GetMapping("/user/data")
    public String getUserData(@RequestParam("name") String name){

//        SecurityContext context = SecurityContextHolder.getContext();
//        Authentication authentication = context.getAuthentication();
//        User user = (User) authentication.getPrincipal();
        return "hello " + name;
    }


    @GetMapping("/user-by-email")
    public String getUserByEmail(@RequestParam("email") String email){
        return "hello " + email;
    }

    @GetMapping("/student")
    public String getStudent(){
        return "Hello student";
    }

    @GetMapping("/librarian")
    public String getLibrarian(){
        return "Hello librarian";
    }
}
