package simpleLoginPage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import simpleLoginPage.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
