package com.example.spring_boot_with_db.controllers;

import com.example.spring_boot_with_db.models.Employee;
import com.example.spring_boot_with_db.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class EmployeeController {

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController() {
        logger.info("Inside employee controller...., object of employeeController - {}", this);
    }

    /**
     * Client --> (Dispatcher servlet) --> Controller  --> Service --> Repository / DAO (Data access object) --> Underlying DB
     *                                 <--             <--         <--                                       <-- return result
     * @param employee
     */



    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee) throws SQLException {
        employeeService.createEmployee(employee);
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") Integer id) throws SQLException {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/employees/all")
    public List<Employee> getEmployees() throws SQLException {
        return employeeService.getEmployees();
    }

    /**
     * EmployeeController --> (has a dependency on) --> EmployeeService
     * EmployeeService --> (has a dependency on) --> EmployeeRepository
     *
     */

    /**
     * CRUD APIs for employee management system
     * Create, Read, Update, Delete
     */

    /**
     * Whenever we use databases instead of in-memory data structures, we encounter certain latency spike in our APIs
     * Trade off:
     *   1. Memory data structure --- fast / latency will be less  + volatile storage (data will be lost if the app server stops)
     *   2. Database -- slow as compared to in-memory data structure + non-volatile storage / persistent storage (data will not be deleted unless and until you hard delete it)
     */
}
