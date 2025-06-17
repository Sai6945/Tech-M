package com.aits.vehicle_service_management.dto;

public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String role;
    private String mobile;

    // Constructors
    public RegisterRequest() {}

    public RegisterRequest(String name, String email, String password, String role, String mobile) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.mobile = mobile;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

    // Getters and Setters
    // ...
    
}