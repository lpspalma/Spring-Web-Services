package com.codeJava.LoginRoleSecurity.DAO;

import com.codeJava.LoginRoleSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}