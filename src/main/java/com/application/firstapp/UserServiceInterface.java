package com.application.firstapp;

import java.util.List;

public interface UserServiceInterface {
    List<User> getUsers();
    void createUser(User user);
    void updateUser(Long id, User user);
    User getUser(Long id);
    void removeUser(Long id);
}
