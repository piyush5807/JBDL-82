package com.example.demo_security_db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface DemoUserRepository extends JpaRepository<DemoUser, Integer> {

    DemoUser findByUsername(String username); // this code will break, if there are more than 1 users with the same username
}
