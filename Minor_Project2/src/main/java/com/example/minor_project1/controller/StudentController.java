package com.example.minor_project1.controller;

import com.example.minor_project1.dtos.CreateStudentRequest;
import com.example.minor_project1.models.Student;
import com.example.minor_project1.models.User;
import com.example.minor_project1.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("")   // permit all
    public Student createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest){
        return studentService.create(createStudentRequest);
    }

    @GetMapping("/{studentId}")    // admin
    public Student getStudentDetails(@PathVariable("studentId") Integer studentId){
        return studentService.findById(studentId);
    }

    /**
     * 1. User id as a foreign key in student and admin table
     * 2. student id and admin id as a foreign key in user table
     * @return
     */

    @GetMapping("/details")    // student
    public Student getStudentDetails2(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        return studentService.findById(user.getSourceEntityId());
    }


}
