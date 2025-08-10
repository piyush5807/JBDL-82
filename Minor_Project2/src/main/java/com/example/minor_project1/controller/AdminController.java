package com.example.minor_project1.controller;

import com.example.minor_project1.dtos.CreateAdminRequest;
import com.example.minor_project1.dtos.CreateStudentRequest;
import com.example.minor_project1.models.Admin;
import com.example.minor_project1.models.Student;
import com.example.minor_project1.services.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("")   // permit all
    public Admin createAdmin(@Valid @RequestBody CreateAdminRequest createAdminRequest){
        return adminService.createAdmin(createAdminRequest);
    }
}
