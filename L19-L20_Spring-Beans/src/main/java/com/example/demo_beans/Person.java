package com.example.demo_beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
public class Person {

    // com.example.demo_beans.Person@64412d34 - spring boot during application boot
    // com.example.demo_beans.Person@272eff6 - developer manually by using new keyword
    // com.example.demo_beans.Person@2515b2cb -

    private static Logger logger = LoggerFactory.getLogger(Person.class);

    private int id; // 0
    private String name; // null

    private boolean isSeniorCitizen;

    public boolean isSeniorCitizen() {
        return isSeniorCitizen;
    }

    public void setSeniorCitizen(boolean seniorCitizen) {
        isSeniorCitizen = seniorCitizen;
    }

    public Person() {
        logger.info("Inside person constructor, this - {}, id - {}, name - {}, seniorCitizen ? - {}", this, id, name, isSeniorCitizen);
    }

    public Person(int id, String name, boolean isSeniorCitizen) {
        this.id = id;
        this.name = name;
        this.isSeniorCitizen = isSeniorCitizen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
