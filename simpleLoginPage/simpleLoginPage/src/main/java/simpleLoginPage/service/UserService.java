package simpleLoginPage.service;

import simpleLoginPage.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
