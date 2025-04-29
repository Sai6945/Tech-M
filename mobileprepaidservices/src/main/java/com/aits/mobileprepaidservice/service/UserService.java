package com.aits.mobileprepaidservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aits.mobileprepaidservice.entity.User;
import com.aits.mobileprepaidservice.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userrepository;
	public User insert(User user) {
		return userrepository.save(user);
	}
	public List<User>fetchAllUsers(){
		List<User> users=userrepository.findAll();
		return users;
	}

}
