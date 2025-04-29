package com.aits.mobileprepaidservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
import com.aits.mobileprepaidservice.repo.UserRepository;
 
@Service
	public class CustomUserDetailsService implements UserDetailsService {
 
	    @Autowired
	    private UserRepository userRepository;
 
	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        var user = userRepository.findByEmail(email)
	            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
	        return new CustomUserDetails(user);
	    }
	}
 
 
 
 
