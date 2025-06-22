package com.example.jpa_hibernate.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository(value = "my-bean2")
@Primary
public class CassandraRepositoryImpl implements MyJPARepository{
    @Override
    public void test() {
        System.out.println("Inside test...");
    }
}
