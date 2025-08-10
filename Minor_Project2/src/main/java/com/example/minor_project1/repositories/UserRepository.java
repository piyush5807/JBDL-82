package com.example.minor_project1.repositories;

import com.example.minor_project1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Integer> {

    // select * from user where username = sharad123

    /**
     * { id - 10, username - shara123, password - $2b.2bjdkklcllc...., authorities - student, sourceEntityId -- 50}
     * here sourceEntityId 50 represent that this record is of a student whose id in the student table is 50
     *
     * {id - 12, username - rishav123, password - $2b.abdsjdd......, authrities - admin, sourceEntityId - 2}
     * here sourceEntityId 2 represent that this record is of an admin whose id in the admin table is 2
     *
     */
    User findByUsername(String username);
}
