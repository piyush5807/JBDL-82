package com.example.minor_project1.models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
public class User implements UserDetails {

    private static final String DELIMITER = ":";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // indexing
    private Integer id;

    @Column(unique = true)
    private String username;
    private String password;

    private String authorities;

    private Integer sourceEntityId;

    @Enumerated(value = EnumType.STRING)
    private SourceEntityType sourceEntityType;

    public SourceEntityType getSourceEntityType() {
        return sourceEntityType;
    }

    public void setSourceEntityType(SourceEntityType sourceEntityType) {
        this.sourceEntityType = sourceEntityType;
    }

    //    @OneToOne
//    @JoinColumn
//    private Student student;
//
//    @OneToOne
//    @JoinColumn
//    private Admin admin;


    public Integer getSourceEntityId() {
        return sourceEntityId;
    }

    public void setSourceEntityId(Integer sourceEntityId) {
        this.sourceEntityId = sourceEntityId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Arrays.stream(this.authorities.split(DELIMITER))
//                .map(authority -> new SimpleGrantedAuthority(authority))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

}
