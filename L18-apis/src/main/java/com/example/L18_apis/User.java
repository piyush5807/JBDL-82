package com.example.L18_apis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class User {

    private static Logger logger = LoggerFactory.getLogger(User.class);

    private int id;
    private String name;
    private Gender gender;

    private Date dob;

    private int age;

    public User() {
        logger.info("User object being created, ref - {}", this);
    }

    // User user = new User()

    public User(int userId, String name, Gender gender, Date dob, int userAge) {
        logger.info("Inside parameterized: User object being created, ref - {}", this);
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.age = age;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        logger.info("inside set id function, id - {}", id);
//        this.id = id;
//    }

    public void setUserId(int id){
        logger.info("inside set user id function, id - {}", id);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setUserName(String name) {
        logger.info("inside set user name function, name - {}", name);
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
