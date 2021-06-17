package simpleLoginPage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import simpleLoginPage.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
