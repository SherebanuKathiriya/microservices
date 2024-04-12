package com.microservices.identityservice;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserCredentialsRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String saveUser(UserCredentials user){
        String encrypted_pass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encrypted_pass);
        repository.save(user);
        return "User added";
    }

    public String generateToken(String username){
        return jwtService.generateToken(username);
    }

    public String validateToken(String token){
        jwtService.validateToken(token);
        return "Token is valid";
    }
}
