package com.computers.appolo.service;


import com.computers.appolo.dto.RegisterRequest;
import com.computers.appolo.entity.User;
import com.computers.appolo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public User register(RegisterRequest req) {
        if (repo.existsByUsername(req.getUsername())) {
            throw new RuntimeException("User already exists");
        }

        User user = User.builder()
                .username(req.getUsername())
                .password(encoder.encode(req.getPassword()))
                .displayName(req.getDisplayName())
                .role("ROLE_USER")
                .build();

        return repo.save(user);
    }

    public User findByUsername(String username) {
        return repo.findByUsername(username).orElse(null);
    }
}
