package com.aits.mobileprepaid.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aits.mobileprepaid.entity.RechargeHistory;
import com.aits.mobileprepaid.entity.User;
import com.aits.mobileprepaid.repo.RechargeHistoryRepository;
import com.aits.mobileprepaid.repo.UserRepository;

@Service
public class AdminService {
	
	@Autowired
	RechargeHistoryRepository rechargehistoryrepository;
	
	@Autowired
	UserRepository userrepository;

	public List<User> getAllUsersExpiring() {

		
		//GetAll the UserDetails.
		    
		 List<User> users= userrepository.findAll();
		 
		 List<User> usersExpiring=new ArrayList<>();
		 
		 //filter the details of the users whose recharge is expiring in the next 3 days
		 
		
		 for(User u:users) {
			 
			 List<RechargeHistory> recharges= rechargehistoryrepository.findByUserId(u.getId());
				 
			//u1->recharges 
			 //recharges->[29/03/2023,29/06/2023,.......29/02/2025]
				
			 if(!recharges.isEmpty()) {
				 
				 //get the last rechargedateObject from the list of recharges
				 
			 RechargeHistory thatmightexpire=recharges.get(recharges.size()-1);
			 
			 LocalDateTime paymentdate=thatmightexpire.getRechargeDate();
			 
			 	LocalDateTime expirydate=paymentdate.plusDays(thatmightexpire.getPlan().getValidityInDays());
			 
		  //I got the expirydate of the rechargehistory
			 	
			//I have to check whether the expiry date is within the range of today and next 3 days
			 
			 	
			 	LocalDateTime todaysdate=LocalDateTime.now();
			 
			 	if( !expirydate.isBefore(todaysdate) && expirydate.isBefore(todaysdate.plusDays(4))) {
			 		
			 		usersExpiring.add(u);
			 		
			 		
			 	}
			 
			 
		 }
		 }
			 
			 
		
	    return usersExpiring;       
		
	}

	
	
	
}
