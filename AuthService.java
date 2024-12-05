package org.nadiaproject.pinapp.service;


import org.nadiaproject.pinapp.entity.UserInfo;
import org.nadiaproject.pinapp.repo.UserRepository;
import org.nadiaproject.pinapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Authenticate user
    public String authenticate(String email, String password) {
        Optional<UserInfo> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            UserInfo user = userOpt.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return jwtUtil.generateToken(email); // Generate a JWT
            }
        }
        throw new RuntimeException("Invalid email or password");
    }

    // Register a new user
    public UserInfo register(String email, String password, String role) {
        String hashedPassword = passwordEncoder.encode(password);
        UserInfo user = new UserInfo(email, hashedPassword, role);
        return userRepository.save(user);
    }
}