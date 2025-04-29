package com.aits.mobileprepaidservice.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aits.mobileprepaidservice.entity.RechargeHistory;
import com.aits.mobileprepaidservice.entity.User;
import com.aits.mobileprepaidservice.repo.RechargeHistoryRepository;
import com.aits.mobileprepaidservice.repo.UserRepository;

@Service
public class AdminService {
	@Autowired
	RechargeHistoryRepository rechargehistoryrepository;
	@Autowired
	UserRepository userrepository;
	public List<User> getAllUsersExpiring(){
		List<User> users= userrepository.findAll();
		List<User>userExpiring=new ArrayList<>();
		for(User u:users) {
			List<RechargeHistory> recharges=rechargehistoryrepository.findByUserId(u.getId());
			if(!recharges.isEmpty()) {
			RechargeHistory thatmightexpire=recharges.get(recharges.size()-1);
			LocalDateTime paymentdate=thatmightexpire.getRechargeDate();
			LocalDateTime expirydate=paymentdate.plusDays(thatmightexpire.getPlan().getValidityInDays());
			// i got the expiry date
			//check whether the expiry date is within today and next three days
			LocalDateTime todaysdate=LocalDateTime.now();
			if(!(expirydate.isBefore(todaysdate)) && expirydate.isBefore(todaysdate.plusDays(4))) {
				 userExpiring.add(u);
			}
			}
				
		}
		return userExpiring;
		
	}

}