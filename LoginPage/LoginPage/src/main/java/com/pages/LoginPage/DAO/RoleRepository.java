package com.pages.LoginPage.DAO;

import com.pages.LoginPage.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
