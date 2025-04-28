package com.aits.mobileprepaid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aits.mobileprepaid.entity.User;
import com.aits.mobileprepaid.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;
	
	
	@PostMapping("/users")
	public User insert(@RequestBody User user) {
		
		return userservice.insert(user);
	  	
		
	}
	
	@GetMapping("/users")
	
	public List<User> fetchAllUsers(){
		
		return userservice.fetchAllUsers();
	}
}
