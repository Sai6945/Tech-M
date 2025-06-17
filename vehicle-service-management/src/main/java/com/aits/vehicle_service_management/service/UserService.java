package com.aits.vehicle_service_management.service;

import com.aits.vehicle_service_management.dto.RegisterRequest;
import com.aits.vehicle_service_management.model.Role;
import com.aits.vehicle_service_management.model.User;
import com.aits.vehicle_service_management.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(RegisterRequest request) {
        if (userRepo.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        User user = new User(
            request.getName(),
            request.getEmail(),
            passwordEncoder.encode(request.getPassword()),
            Role.valueOf(request.getRole().toUpperCase()), // Convert String to Enum
            request.getMobile()
        );

        return userRepo.save(user);
    }

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public List<User> getServiceAdvisors() 
	{
		return userRepo.findByRole(Role.SERVICE_ADVISOR);
		
	}
}