package com.aits.mobileprepaidservice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
 
import com.aits.mobileprepaidservice.entity.RechargeHistory;
import com.aits.mobileprepaidservice.entity.RechargePlan;
import com.aits.mobileprepaidservice.entity.User;
import com.aits.mobileprepaidservice.repo.RechargeHistoryRepository;
import com.aits.mobileprepaidservice.repo.RechargePlanRepository;
import com.aits.mobileprepaidservice.repo.UserRepository;
 
@Service
public class RechargeService {
	
	  @Autowired
	  private  UserRepository userRepo;
	  @Autowired
	    private  RechargePlanRepository planRepo;
	  @Autowired
	    private  RechargeHistoryRepository historyRepo;
	   @Autowired
	    private  JavaMailSender mailSender;
	  
	  public String recharge(Long userId, Integer planId, String paymentMethod) {
	        Optional<User> userOpt = userRepo.findById(userId);
	        Optional<RechargePlan> planOpt = planRepo.findById(planId);
 
	        if (userOpt.isEmpty() || planOpt.isEmpty()) {
	            return "User or Plan not found.";
	        }
	        
	        //if the pland and user exists he has to go for payment..
	        
	        //after payment I have to update the recharge history of the user object.
	        
	        RechargeHistory history = new RechargeHistory();
	        //empty
	        
	        //set all the paramaters of rechargehistory and store it as a new row in recharge_history table
	        history.setUser(userOpt.get());
	        history.setPlan(planOpt.get());
	        history.setPaymentMethod(paymentMethod);
	        history.setRechargeDate(LocalDateTime.now());
	        historyRepo.save(history);
 
	        sendConfirmationEmail(userOpt.get().getEmail(), planOpt.get());
	        return "Recharge successful!";
	    }
	  
	  private void sendConfirmationEmail(String to, RechargePlan plan) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject("Recharge Confirmation");
	        message.setText("You have successfully recharged with plan: " + plan.getName()
	                + " | Price: ₹" + plan.getPrice()
	                + " | Validity: " + plan.getValidityInDays() + " days");
 
	        mailSender.send(message);
	    }
	  
	  public List<RechargeHistory> getUserHistory(Long userId) {
	        return historyRepo.findByUserId(userId);
	    }
 
}
