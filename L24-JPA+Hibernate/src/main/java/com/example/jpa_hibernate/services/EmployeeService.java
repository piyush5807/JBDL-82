package com.example.jpa_hibernate.services;

import com.example.jpa_hibernate.models.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service // @Component
public class EmployeeService {

    private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);


    public EmployeeService() {
        logger.info("Inside employee service...., object of employeeService - {}", this);
    }


    public void createEmployee(Employee employee) throws SQLException {
//        employeeRepository.createEmployee(employee);
    }

    public Employee getEmployee(Integer id) throws SQLException {
//        return employeeRepository.getEmployee(id);
        return null;
    }

    public List<Employee> getEmployees() throws SQLException {
//        return employeeRepository.getEmployees();
        return null;
    }
}
