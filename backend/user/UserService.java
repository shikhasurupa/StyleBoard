package org.proj.styleboard.service;

import org.proj.styleboard.entity.UserInfo;
import org.proj.styleboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register a new user
    public UserInfo registerUser(String email, String name, String password) {
        UserInfo user = new UserInfo(email, name, password);
        return userRepository.save(user);
    }

    // Find user by username
    public Optional<UserInfo> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Find user by ID
    public Optional<UserInfo> findUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update user information
    public UserInfo updateUser(UserInfo user) {
        return userRepository.save(user);
    }

    // Delete user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}