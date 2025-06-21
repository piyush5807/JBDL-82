package com.example.spring_boot_with_db;

public class Test {

    public String A(){
        return "Hello world";
    }

    public static void main(String[] args) {
        Test test = new Test();
        String result = test.A();
        result.toUpperCase();

        Test test2 = new Test();
        test2.A().toUpperCase();
    }
}
