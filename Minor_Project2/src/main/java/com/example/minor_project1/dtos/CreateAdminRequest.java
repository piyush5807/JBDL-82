package com.example.minor_project1.dtos;

import com.example.minor_project1.models.Admin;
import com.example.minor_project1.models.Department;
import com.example.minor_project1.models.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateAdminRequest {

    @NotBlank
    private String name;

    private String username;
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Admin convertTo(){

        Admin admin = new Admin();
        admin.setName(this.name);

        return admin;
    }
}
