package com.example.minor_project1.dtos;

import com.example.minor_project1.models.Department;
import com.example.minor_project1.models.Student;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateStudentRequest {

    @NotBlank
    private String name;

    @NotNull
    private Department department;

    @NotBlank
    private String rollNumber;
    @NotBlank
    @Email
    private String email;
    private String country;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student convertTo(){

        Student student = new Student();
        student.setName(this.name);
        student.setDepartment(this.department);
        student.setEmail(this.email);
        student.setRollNumber(this.rollNumber);
        student.setCountry(this.country);

        return student;
    }
}
