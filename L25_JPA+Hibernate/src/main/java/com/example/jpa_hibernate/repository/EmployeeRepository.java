package com.example.jpa_hibernate.repository;

import com.example.jpa_hibernate.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
