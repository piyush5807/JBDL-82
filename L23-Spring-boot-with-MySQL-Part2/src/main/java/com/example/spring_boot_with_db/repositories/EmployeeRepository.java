package com.example.spring_boot_with_db.repositories;

import com.example.spring_boot_with_db.models.Department;
import com.example.spring_boot_with_db.models.Employee;
import com.example.spring_boot_with_db.models.EmploymentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
//@Repository
public class EmployeeRepository {

    private static Connection connection = null;

    private static Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);

    private static Connection getConnection() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db_82", "root", "");
        }

        return connection;
    }

    EmployeeRepository() throws SQLException {
        logger.info("Inside employee repository...., object of employeeRepository - {}", this);
        createEmployeeTable();
    }

    private void createEmployeeTable() throws SQLException {
        String sql = "CREATE TABLE if not exists employees(id int primary key, name varchar(50), age int, department varchar(20), " +
                "employmentType varchar(20), salary bigint, joiningDate date )";

        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);

    }

    public void createEmployee(Employee employee) throws SQLException {

        // This is responsible interacting with the underlying database
        // i.e writing sql queries here.

        // Prepared statement

        String sql = "INSERT INTO employees(id, name, age, department, employmentType, salary, joiningDate) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)"; // these question marks are known as placeholders

//        String sql2 = "INSERT INTO employees(id, name, age, department, employmentType, salary, joiningDate) " +
//                "VALUES (" + 1 + ")";
////        String sql2 = "INSERT INTO employees(id, name, age, department, employmentType, salary, joiningDate) " +
////                "VALUES (" + 2 + ")";

        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, employee.getId());
        statement.setString(2, employee.getName());
        statement.setInt(3, employee.getAge());
        statement.setString(4, employee.getDepartment().name());
        statement.setString(5, employee.getEmploymentType().name());
        statement.setLong(6, employee.getSalary());
        statement.setDate(7, new Date(employee.getJoiningDate().getTime()));


        statement.execute();
    }

    public Employee getEmployee(Integer id) throws SQLException {

        String sql = "select * from employees where id = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);


        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            int employeeId = resultSet.getInt(1);
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            Department department = Department.valueOf(resultSet.getString(4));
            EmploymentType employmentType = EmploymentType.valueOf(resultSet.getString("employmentType"));
            java.util.Date joiningDate = new java.util.Date(resultSet.getDate(6).getTime());
            Long salary = resultSet.getLong(7);

            Employee employee = new Employee();
            employee.setId(employeeId);
            employee.setName(name);
            employee.setAge(age);
            employee.setDepartment(department);
            employee.setEmploymentType(employmentType);
            employee.setSalary(salary);
            employee.setJoiningDate(joiningDate);

            return employee;
        }

        return null;



//        statement.executeUpdate() only required during DML query
        // DDL - Data definition language // alter table, create table, create index, drop table, drop index, drop database
        // DML - Data manipulation language // update, insert, delete
    }

    public List<Employee> getEmployees() throws SQLException {

        List<Employee> employees = new ArrayList<>();

        String sql = "select * from employees";
        Statement statement = getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            int employeeId = resultSet.getInt(3);
            String name = resultSet.getString("name");
            int age = resultSet.getInt(1);
            Department department = Department.valueOf(resultSet.getString(4));
            EmploymentType employmentType = resultSet.getString("employmentType") == null ? null: EmploymentType.valueOf(resultSet.getString("employmentType"));
            java.util.Date joiningDate = new java.util.Date(resultSet.getDate(5).getTime());
            Long salary = resultSet.getLong(6);

            Employee employee = new Employee();
            employee.setId(employeeId);
            employee.setName(name);
            employee.setAge(age);
            employee.setDepartment(department);
            employee.setEmploymentType(employmentType);
            employee.setSalary(salary);
            employee.setJoiningDate(joiningDate);

            employees.add(employee);
        }

        return employees;
    }

    public Employee deleteEmployee(){
        // sql = delete from employees where id = ?
        // executeUpdate()
        return null;
    }

    public Employee updateEmployee(int id, Employee employee){ // patch
        String sql = "update employees set ";
        if(employee.getName() != null){
            sql += " name = ? ";
        }

        if(employee.getDepartment() != null){
            sql += ", department = ?";
        }
        // sql = update employees set name = ?, department = ? where id = ?
        // executeUpdate()
        return null;
    }
}
