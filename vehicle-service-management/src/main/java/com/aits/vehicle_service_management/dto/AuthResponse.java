package com.aits.vehicle_service_management.dto;

public class AuthResponse {
    private String token;
    private String email;
    private String role;
    private Long userId;
    private String name;

    public AuthResponse() {
    }

    public AuthResponse(String token, String email, String role, Long userId, String name) {
        this.token = token;
        this.email = email;
        this.role = role;
        this.userId = userId;
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}