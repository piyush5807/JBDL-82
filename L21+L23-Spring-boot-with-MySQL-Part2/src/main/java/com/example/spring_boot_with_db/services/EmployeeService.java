package com.example.spring_boot_with_db.services;

import com.example.spring_boot_with_db.models.Employee;
import com.example.spring_boot_with_db.repositories.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service // @Component
public class EmployeeService {

    private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeService() {
        logger.info("Inside employee service...., object of employeeService - {}", this);
    }


    public void createEmployee(Employee employee) throws SQLException {
        employeeRepository.createEmployee(employee);
    }

    public Employee getEmployee(Integer id) throws SQLException {
        return employeeRepository.getEmployee(id);
    }

    public List<Employee> getEmployees() throws SQLException {
        return employeeRepository.getEmployees();
    }
}
