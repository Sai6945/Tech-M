package com.aits.vehicle_service_management.controller;

import com.aits.vehicle_service_management.dto.AuthRequest;
import com.aits.vehicle_service_management.dto.AuthResponse;
import com.aits.vehicle_service_management.dto.RegisterRequest;
import com.aits.vehicle_service_management.model.Role;
import com.aits.vehicle_service_management.model.User;
import com.aits.vehicle_service_management.repository.UserRepository;
import com.aits.vehicle_service_management.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already registered.");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setMobile(request.getMobile());
        user.setRole(Role.valueOf(request.getRole().toUpperCase())); // Assuming role is String or Enum-compatible

        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name(), user.getId());

        AuthResponse response = new AuthResponse(
                token,
                user.getEmail(),
                user.getRole().name(),
                user.getId(),
                user.getName()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElse(null);

        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name(), user.getId());

        AuthResponse response = new AuthResponse(
                token,
                user.getEmail(),
                user.getRole().name(),
                user.getId(),
                user.getName()
        );

        return ResponseEntity.ok(response);
    }
}