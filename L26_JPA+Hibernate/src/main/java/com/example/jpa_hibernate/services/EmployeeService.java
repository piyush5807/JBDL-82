package com.example.jpa_hibernate.services;

import com.example.jpa_hibernate.models.Department;
import com.example.jpa_hibernate.models.Employee;
import com.example.jpa_hibernate.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service // @Component
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);


    public EmployeeService() {
        logger.info("Inside employee service...., object of employeeService - {}", this);
    }


    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

//    public Employee getEmployee(Integer id) throws SQLException {
////        return employeeRepository.getEmployee(id);
//        Employee employee = employeeRepository.getById(id);
////        if(employee == null){
////            throw new BadRequestException();
////        }
//
//        return employee;
//    }

    public Employee getEmployee(Integer id) {
//        return employeeRepository.getEmployee(id);
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getEmployees() throws SQLException {
//        return employeeRepository.getEmployees();
        return employeeRepository.findAll();
    }

    public Employee deleteEmployee(Integer id){
        Employee employeeToBeDeleted = getEmployee(id);
        employeeRepository.deleteById(id);
        return employeeToBeDeleted;
    }

    public Employee updateEmployee(Integer id, Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeePartial(Integer id, Employee newEmployee) { // age, salary
        newEmployee.setId(id);

        // Get the employee details
        Employee employeeFromDB = getEmployee(id);



        // lodash , json-simple, jackson

        return employeeRepository.save(newEmployee);
    }

    public List<Employee> getEmployeesOlderThan(int age) {
        return employeeRepository.getAllEmployeesOlderThanAge(age);
    }

    public List<Employee> getEmployeesWithDeptAndSalary(String department, Long salary){
        return employeeRepository.findByDepartmentAndSalaryGreaterThan(Department.valueOf(department), salary);
    }

    public List<Employee> findByAgeBetween(int start, int end){
        return employeeRepository.findByAgeBetween(start, end);
    }
}
