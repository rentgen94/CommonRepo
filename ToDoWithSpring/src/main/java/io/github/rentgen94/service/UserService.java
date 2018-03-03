package io.github.rentgen94.service;

import io.github.rentgen94.model.User;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
}
