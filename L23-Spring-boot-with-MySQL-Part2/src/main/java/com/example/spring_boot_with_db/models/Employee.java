package com.example.spring_boot_with_db.models;


import java.util.Date;

//@Getter
//@Setter
////@AllArgsConstructor
////@NoArgsConstructor
////@ToString
//@Builder
//@Data
public class Employee {
    private Integer id;
    private String name;

    private Integer age;

    private Department department;

    private EmploymentType employmentType;

    private Long salary;

    private Date joiningDate;

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

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }
}
