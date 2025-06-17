package com.aits.vehicle_service_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;  // Change the type to Role enum

    private String mobile;

    // Constructors
    public User() {}

    public User(String name, String email, String password, Role role, String mobile) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;  // Use Role enum here
        this.mobile = mobile;
    }

    // Getters and Setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;  // Return Role enum
    }

    public void setRole(Role role) {
        this.role = role;  // Set Role enum
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}