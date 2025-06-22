package com.example.jpa_hibernate.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Getter
//@Setter
//@NoArgsConstructor
//@Builder
//@AllArgsConstructor
//@ToString
@Entity // This annotation is useful to tell hibernate to create a table / relation in the sql server
@Component
@Table(name = "employees")
public class Employee { // employee

    // create table employee (id int )

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // IDENTITY means the underlying server generates an auto incremented key and associate it with id column
    private Integer id;     // long  ? Long          int ? Integer

    @Column(name = "employee-name")
    private String name;

    private Integer age;

    @Enumerated(value = EnumType.STRING)
    private Department department;

    @Enumerated(value = EnumType.ORDINAL)
    private EmploymentType employmentType;

    private Integer salary;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(EmploymentType employmentType) {
        this.employmentType = employmentType;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
