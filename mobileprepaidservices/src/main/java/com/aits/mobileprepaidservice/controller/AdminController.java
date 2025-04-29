package com.aits.mobileprepaidservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aits.mobileprepaidservice.entity.User;
import com.aits.mobileprepaidservice.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService adminservice;
	@GetMapping("/usersexpiring")
	public List<User>getAllUsersExpiring(){
		return adminservice.getAllUsersExpiring();
	}

}
