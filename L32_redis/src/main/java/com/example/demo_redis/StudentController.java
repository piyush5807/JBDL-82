package com.example.demo_redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("")
    public String createStudent(@RequestBody Student student){
        return studentService.create(student);
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") String studentId){
        return studentService.getById(studentId);
    }
}
