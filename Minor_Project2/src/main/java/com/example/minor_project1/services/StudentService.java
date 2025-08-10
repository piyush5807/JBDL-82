package com.example.minor_project1.services;

import com.example.minor_project1.dtos.CreateStudentRequest;
import com.example.minor_project1.models.Student;
import com.example.minor_project1.models.User;
import com.example.minor_project1.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    StudentRepository studentRepository;

    public Student create(CreateStudentRequest createStudentRequest){

        // Creating a student record / row in the student table
        Student student = createStudentRequest.convertTo();
        student = this.studentRepository.save(student);

        User user = new User();
        user.setUsername(createStudentRequest.getUsername());
        user.setPassword(passwordEncoder.encode(createStudentRequest.getPassword()));
        user.setAuthorities("admin");
        user.setSourceEntityId(student.getId());

        return student;
    }

    // controller --> service (findById(2)) => student::2 --> {}
    // controller --> service (findById(3)) =>

    public Student findById(Integer studentId){
        return this.studentRepository.findById(studentId).orElse(null);
    }
}
