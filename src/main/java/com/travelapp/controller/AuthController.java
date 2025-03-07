package com.travelapp.controller;

import com.travelapp.model.User;
import com.travelapp.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        authService.registerUser(user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getNativeLocation());
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        authService.authenticateUser(user.getUsername(), user.getPassword());
        return ResponseEntity.ok("Login successful!");
    }
}

