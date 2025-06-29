package com.example.minor_project1.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Department department;

    @Column(unique = true, nullable = false)
    private String rollNumber;

    @Column(unique = true, nullable = false)
    private String email;

    private String country;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @OneToMany(mappedBy = "my_student")       // This is adding a back reference
    private List<Book> bookList;

    // Books assigned to the student;

    // Get the student details
    // select * from student where id = ?


    // select * from books where studentId = ?

}
