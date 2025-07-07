package com.example.minor_project1.services;

import com.example.minor_project1.dtos.CreateStudentRequest;
import com.example.minor_project1.models.Student;
import com.example.minor_project1.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student create(CreateStudentRequest createStudentRequest){

        Student student = createStudentRequest.convertTo();
        return this.studentRepository.save(student);
    }

    public Student findById(Integer studentId){
        return this.studentRepository.findById(studentId).orElse(null);
    }
}
