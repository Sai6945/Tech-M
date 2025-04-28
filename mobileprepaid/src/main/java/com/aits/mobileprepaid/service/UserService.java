package com.aits.mobileprepaid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.aits.mobileprepaid.entity.User;
import com.aits.mobileprepaid.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userrepository;
	
	public User insert(User user) {
		
		return userrepository.save(user);
	}

	public List<User> fetchAllUsers() {
		// TODO Auto-generated method stub
		List<User> users= userrepository.findAll();
		
		return users;
	}

	
	
}
