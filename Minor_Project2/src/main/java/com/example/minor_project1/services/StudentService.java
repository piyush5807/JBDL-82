package com.example.minor_project1.services;

import com.example.minor_project1.dtos.CreateStudentRequest;
import com.example.minor_project1.models.Student;
import com.example.minor_project1.models.User;
import com.example.minor_project1.repositories.StudentCacheRepository;
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

    @Autowired
    StudentCacheRepository studentCacheRepository;

    public Student create(CreateStudentRequest createStudentRequest){

        // Creating a student record / row in the student table
        Student student = createStudentRequest.convertTo();
        student = this.studentRepository.save(student);

        this.studentCacheRepository.create(student);

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

        Student student = this.studentCacheRepository.get(studentId);
        if(student == null){ // cache miss
            student = this.studentRepository.findById(studentId).orElse(null);

            // TODO: Make this as async because the client / FE doesn't need to wait for the response until the cache syncs the data from db
            this.studentCacheRepository.create(student); // For future cache hits
        }
        return student;
    }


    public void updateStudent(Integer studentId, Student student){
        // Either remove the data from the cache, so that next time, there will be a cache miss and latest data will be fetched from db
        // or update the cache data in addition to updating in db
        this.studentRepository.save(student);
    }
}
