package com.example.demo_security_db;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class DemoUser implements UserDetails {

    private static final String DELIMITER = ":";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // indexing
    private Integer id;

    @Column(unique = true)    // indexing
    private String username;
    private String password;   // pwd

    private String authorities;       // [admin, librarian, hod ] --> admin#librarian#hod

//    private boolean isAccountNonLocked;
//
//    private boolean isAccountNonExpired;
//
//    private boolean isCredentialsNonExpired;
//
//    private boolean isEnabled;


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


    //    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
//        String[] authorities = this.authorities.split(DELIMITER);
//        for(String authority: authorities){
//            SimpleGrantedAuthority sga = new SimpleGrantedAuthority(authority);
//            grantedAuthorityList.add(sga);
//        }
//
//        return grantedAuthorityList;
//    }

    @Override
    public String getPassword() {
        return this.password;
    }



    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
