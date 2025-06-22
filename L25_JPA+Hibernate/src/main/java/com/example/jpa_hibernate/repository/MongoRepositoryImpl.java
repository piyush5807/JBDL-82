package com.example.jpa_hibernate.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository(value = "my-bean1") // describing the name of the bean
@Primary
public class MongoRepositoryImpl implements MyJPARepository{
    @Override
    public void test() {
        System.out.println("Inside test...");
    }
}
