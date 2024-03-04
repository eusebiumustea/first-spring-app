package com.application.firstapp;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        User currentUser = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User not found"));
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setEmail(user.getEmail());
        currentUser.setFollowers(user.getFollowers());
        currentUser.setRole(user.getRole());
        userRepository.save(currentUser);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalStateException(String.format("User with id %s NOT found!", id)));
    }
    @Override
    public void removeUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalStateException("User not found");
        }
        userRepository.deleteById(id);
    }
}
