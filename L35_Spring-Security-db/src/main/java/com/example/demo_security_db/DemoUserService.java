package com.example.demo_security_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DemoUserService implements UserDetailsService {

    @Autowired
    DemoUserRepository demoUserRepository;

    // U1 -- abc123    abc#
    // U2 -- def123    def.
    // U3 -- abc123    abc#    [u1, u3]

    /**
     * This function loadUserByUsername is not at all database dependent, you just need to define from where and how to retrieve the data
     */

    @Autowired
    PasswordEncoder passwordEncoder; // which is coming from securityConf

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return demoUserRepository.findByUsername(username);
    }

    public DemoUser createStudent(String username, String password){
        DemoUser demoUser = new DemoUser();
        demoUser.setUsername(username);
        demoUser.setPassword(passwordEncoder.encode(password));
        demoUser.setAuthorities("student");

        return demoUserRepository.save(demoUser);
    }


}
