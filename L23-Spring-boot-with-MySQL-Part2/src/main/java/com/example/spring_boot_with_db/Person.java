package com.example.spring_boot_with_db;

public class Person {

    int id;
    String name;

    public Person id(int id){
        this.id = id;
        return this;
    }

    public Person name(String nameParam){
        name = nameParam;
        return this;
    }

    Person(){
        System.out.println("person object - " + this);
        System.out.println("id = " + id + ", name  = " + name);
    }

    public static void main(String[] args) {
//        Person person = new Person();

        Person person2 = new Person().id(2).name("Piyush");

        System.out.println("Name = " + person2.name + ", id = " + person2.id);
    }
}
