package com.example.jpa_hibernate.repository;

import com.example.jpa_hibernate.models.Department;
import com.example.jpa_hibernate.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // JPQL - Java persistence query language
    // Native query - Same format as that of sql

    // No query

    @Query("select e from Employee e where createdAt > :employeeAge")
//    @Query("select e from Employee e where e.age = ?1")
    List<Employee> getAllEmployeesOlderThanAge(int employeeAge);

    // function to return all the employees who are in tech department and salary > 50000

    @Query(value = "select * from employees where department = ?1 and salary > ?2", nativeQuery = true)
    List<Employee> getEmployees(String department, Long salary);

    // gte // greater than equal >=
    // gt // greater than >
    // eq // ...   =

    List<Employee> findByDepartmentAndSalaryGreaterThan(Department department, Long salary);

    List<Employee> findByAgeBetween(int start, int end);

    // select * from employees where age > 30 or (department = TECH and employmentType = INTERN)
    // findByAgeGreaterThanOrDepartmentAndEmploymentType
}
