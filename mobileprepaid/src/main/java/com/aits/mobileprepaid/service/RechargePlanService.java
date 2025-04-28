package com.aits.mobileprepaid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aits.mobileprepaid.entity.RechargePlan;
import com.aits.mobileprepaid.repo.RechargePlanRepository;

	@Service
	public class RechargePlanService {
		
		@Autowired
	    private  RechargePlanRepository repository;
	
	    
	
	    public List<RechargePlan> getAllPlans() {
	        return repository.findAll();
	    }
	
	    public List<RechargePlan> getPlansByCategory(String category) {
	        return repository.findByCategory(category);
	    }
	
		public RechargePlan insert(RechargePlan rechargeplan) {
			// TODO Auto-generated method stub
			
			return repository.save(rechargeplan);
		}
	}