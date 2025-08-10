package com.example.minor_project1.services;

import com.example.minor_project1.dtos.CreateAdminRequest;
import com.example.minor_project1.models.Admin;
import com.example.minor_project1.models.SourceEntityType;
import com.example.minor_project1.models.User;
import com.example.minor_project1.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Admin createAdmin(CreateAdminRequest createAdminRequest){

        Admin admin = createAdminRequest.convertTo();
        admin = this.adminRepository.save(admin);

        User user = new User();
        user.setUsername(createAdminRequest.getUsername());
        user.setPassword(passwordEncoder.encode(createAdminRequest.getPassword()));
        user.setAuthorities("admin");
        user.setSourceEntityId(admin.getId());
        user.setSourceEntityType(SourceEntityType.ADMIN);

        return admin;
    }
}
