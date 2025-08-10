package com.example.major_project.dto;

import com.example.major_project.models.Phone;
import com.example.major_project.models.User;

public class CreateUserDTO {

    private String name;

    private Integer age;

    private String email;

    private Phone phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public User toUser(){
        User user = new User();
        user.setAge(this.getAge());
//        user.setContact(this.getPhone());
        user.setEmail(this.getEmail());
        user.setName(this.getName());

        // TODO: Handle null pointer exceptions elegantly
        user.setPhone(this.getPhone().getCountryCode() + this.getPhone().getNumber());

        return user;
    }
}
