package com.application.firstapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/v1/users")
@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
      return userService.getUsers();
    }
    @GetMapping(path = "{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }
    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }
    @DeleteMapping(path = "{id}")
    public void updateUser(@PathVariable Long id) {
        userService.removeUser(id);
    }
}
