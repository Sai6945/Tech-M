package com.aits.vehicle_service_management.service;

import com.aits.vehicle_service_management.dto.AuthRequest;
import com.aits.vehicle_service_management.dto.AuthResponse;
import com.aits.vehicle_service_management.model.User;
import com.aits.vehicle_service_management.repository.UserRepository;
import com.aits.vehicle_service_management.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthResponse authenticate(AuthRequest request) {
        // Fetch user by email
        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Validate password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Generate JWT token using the role's name (i.e., string representation)
        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name(), user.getId());

        // Return AuthResponse
        return new AuthResponse(
                token,
                user.getEmail(),
                user.getRole().name(),  // Convert enum to String for AuthResponse
                user.getId(),
                user.getName()
        );
    }
}