package com.aits.vehicle_service_management.controller;

import com.aits.vehicle_service_management.dto.RegisterRequest;
import com.aits.vehicle_service_management.model.User;
import com.aits.vehicle_service_management.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*") // Allow cross-origin requests (good for frontend)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegisterRequest request) {
        return userService.registerUser(request);
    }
    
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/service-advisors")
    public List<User> getServiceAdvisors() {
        return userService.getServiceAdvisors();
    }
    
}